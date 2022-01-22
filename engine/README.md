# Flowless (engine)

A library capable of executing flows. In practice this will be a dependency of auth-server in the future.

## Flow development lifecycle

A high level depiction of the process is:

- Developer writes a flow and prepares required assets. These are transferred to its destination manually or through a manager application
- A flow descriptor is created. This contains metadata in json format                 
- Flow code (in DSL) is transformed to Javascript code (see the `transpiler` README for details)
- JS code is transferred to its destination
- A url is crafted for launching the given flow based on the metadata

## Internals

The engine receives a request (eg. to trigger a flow), locates the relevant JS code and executes it by leveraging Mozilla [Rhino](https://github.com/mozilla/rhino/) scripting engine. Of course, it's more complicated than that in practice!

**Key points**:

- Code runs in the JVM all the time
- No dependencies on 3rd party javascript libraries. Generated code is (plain) vanilla javascript as well as the utility file which is ~6KB
- There is no usage of asynchronous paradigms at all (no events, callbacks, extra threads, etc.). It remains in the classic request/response Java servlet lifecycle

The key driver for engine design was that of [continuations](https://en.wikipedia.org/wiki/Continuation) (not to be confused with [Jetty continuations](https://www.eclipse.org/jetty/documentation/jetty-9/index.html#continuations)). With continuations we can express a flow as if it were a straight sequence despite there are pauses in the middle: those gaps between an HTTP response and the next request. 

According to previous research Rhino is the only mechanism that can bring continuations into Java.

While a continuation can be stored in memory till flow completion, in order to preserve statelessness it has to be persisted to storage at every pause. This way the proper *state* can be loaded when the continuation is resumed afterwards.  

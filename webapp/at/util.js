let 
    _primitiveUtils = Packages.org.gluu.flowless.engine.misc.PrimitiveUtils,
    _scriptUtils = Packages.org.gluu.flowless.engine.script.ScriptUtils,
    _logUtils = Packages.org.gluu.flowless.engine.script.LogUtils,
    _booleanCls = new Packages.java.lang.Class.forName("java.lang.Boolean"),
    _numberCls = new Packages.java.lang.Class.forName("java.lang.Number"),
    _integerCls = new Packages.java.lang.Class.forName("java.lang.Integer"),
    _stringCls = new Packages.java.lang.Class.forName("java.lang.String"),
    _listCls = new Packages.java.lang.Class.forName("java.util.List"),
    _mapCls = new Packages.java.lang.Class.forName("java.util.Map")

function _renderReplyFetch(base, page, allowCallbackResume, data) {
    if (_isObject(data))
        return _scriptUtils.pauseForRender(base + "/" + page, allowCallbackResume, data)
    throw new TypeError("Data passed to RRF was not an object")
}

function _redirectFetchAtCallback(url) {
    if (_isString(url)) {
        let jsonStr = _scriptUtils.pauseForExternalRedirect(url).second
        return JSON.parse(jsonStr)
    }
    throw new TypeError("Data passed to RFAC was not a string")
}

function _log() {
    _logUtils.log(Array.from(arguments).map(_scan))
}

function _equals(a, b) {
    return _scriptUtils.testEquality(_scan(a), _scan(b))
}

function _actionCall() {
    // See JSGenerator.ftl
    //1st arg: action classname
    //2nd arg: action method name
    //3rd: array of action params
    
    let args = Array.from(arguments)
    let act = args.splice(0, 2)
    let method = act[1]

    if (!_isString(act[0]))
        throw new TypeError("Action class and method name are not strings")
    
    if (_isNil(method)) {
        //Extract method from act[0]
        
        let parts = act[0].split("#", 3)
        method = parts.length == 2 ? parts[1] : ""
    }
    
    if (method === "") throw new Error("Missing action method");

    return _scriptUtils.callAction(act[0], method, args.map(_scan))

}

function _flowCall() {
    // See JSGenerator.ftl
    //1st arg: parent's base path 
    //2nd: array of url overrides
    //3rd: name of the flow to branch to
    //4th: reserved for future use
    //rest: the params for the flow call
    
    let args = Array.from(arguments)
    let removed = args.splice(0, 4)

    if (!_isString(removed[2]))
        throw new TypeError("Flow name is not a string")
    
    let f = _scriptUtils.prepareSubflow(removed[2], removed[0], removed[1])    
    let result = f.apply(null, args.map(_scan))
    
    _scriptUtils.closeSubflow()
    return result

}

function _finish(val) {

    let javaish = _javaish(val)
    
    if (_isBool(val, javaish))
        return { success: val }
    else if (_isObject(val, javaish) && _isBool(val.success))
        return val

    throw new Error ("Cannot determine whether Finish value should be successful or not")

}

function _abort(data) {
    return { aborted: true, data: data }
}

function _scan(val) {
    //treat undefined, null, or a Java method reference as null
    if (_isNil(val) || typeof val === "function") return null    
    return val
}

function _ensureNumber(val, msg) {
    if (!_isNumber(val)) throw new TypeError(msg)
}

function _ensureList(val, msg) {
    if (!_isList(val)) throw new TypeError(msg)
}

//Ensures val is a string and returns it
//(short function name used so generated code is compact)
function _sc(val, symbol) {
    if (_isString(val)) return val
    throw new TypeError(symbol + " is not a string")
}

//Ensures val is an integer (greater than or equal to 0) and returns it
//(short function name used so generated code is compact)
function _ic(val, symbol) {

    if (_javaish(val)) {
        if (_integerCls.isInstance(val) && val >= 0)
            return val
    } else if (Number.isInteger(val) && val >= 0)
        return val

    throw new TypeError(symbol + " is not zero or a positive integer")

}

function _isObject(val, javaish) {

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    if (jish) {
        let cls = val.getClass()
        return !(_stringCls.isInstance(val) || _primitiveUtils.isPrimitive(cls, true) || cls.isArray())
    }
    return !_isNil(val) && !Array.isArray(val) && typeof val === "object"

}

function _isMap(val, javaish) {
    let jish = _isNil(javaish) ? _javaish(val) : javaish
    return jish ? _mapCls.isInstance(val) : _isObject(val, false)
}

function _isList(val, javaish) {

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    if (jish) {
        let cls = val.getClass()
        return cls.isArray() || _listCls.isAssignableFrom(cls)
    }
    return Array.isArray(val)

}

function _isBool(val, javaish) {
    let jish = _isNil(javaish) ? _javaish(val) : javaish
    return jish ? _booleanCls.isInstance(val) : typeof val === "boolean"
}

function _isString(val, javaish) {
    let jish = _isNil(javaish) ? _javaish(val) : javaish
    return jish ? _stringCls.isInstance(val) : typeof val === "string"
}

function _isNumber(val, javaish) {

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    if (jish)
        //Only Double/Float/Long/Integer/Short objects 
        return _numberCls.isInstance(val) && _primitiveUtils.isPrimitive(val.getClass(), true) 
    return typeof val === "number" && !isNaN(val)

}

function _isNil(val) {
    //undefined and null are treated the same way here... 
    return val == null
}

function _javaish(val) {

    try {
        val.getClass()
        //Instances of org.mozilla.javascript.NativeArray/NativeObject throw TypeError in the above line
        //as well as native boolean/string/array/object defined in Javascript code
        //plus null
        return true
    } catch (e) {
        return false
    }

}

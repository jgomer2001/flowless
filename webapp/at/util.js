let 
    _primitiveUtils = Packages.org.gluu.flowless.engine.misc.PrimitiveUtils,
    _scriptUtils = Packages.org.gluu.flowless.engine.script.ScriptUtils,
    _logUtils = Packages.org.gluu.flowless.engine.script.LogUtils,
    _booleanCls = new Packages.java.lang.Class.forName("java.lang.Boolean"),
    _numberCls = new Packages.java.lang.Class.forName("java.lang.Number"),
    _stringCls = new Packages.java.lang.Class.forName("java.lang.String")

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
    _logUtils.log(Array.from(arguments))
}

function _equals(a, b) {
    return _scriptUtils.testEquality(a, b)
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

    return _scriptUtils.callAction(act[0], method, args.map(x => _isNil(x) ? null : x))

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
    let result = f.apply(null, args.map(x => _isNil(x) ? null : x))
    
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

function _ensureNumber(val, msg) {
    if (!_isNumber(val)) throw new Error(msg)
}

function _isObject(val, javaish) {

    if (_isNil(val)) return false

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    if (jish)
        return !(_stringCls.isInstance(val) || _primitiveUtils.isPrimitive(val.getClass(), true)
            || val.getClass().isArray())
    return !Array.isArray(val) && typeof val === "object"

}

function _isBool(val, javaish) {

    if (_isNil(val)) return false

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    return jish ? _booleanCls.isInstance(val) : typeof val === "boolean"

}

function _isString(val, javaish) {

    if (_isNil(val)) return false

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    return jish ? _stringCls.isInstance(val) : typeof val === "string"

}

function _isNumber(val, javaish) {

    if (_isNil(val)) return false

    let jish = _isNil(javaish) ? _javaish(val) : javaish
    if (jish)
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
        //Instances of org.mozilla.javascript.NativeArray/org.mozilla.javascript.NativeObject throw TypeError in the above line
        //as well as native boolean/string/array/object defined in Javascript code
        //plus null (whether from Java or JS)
        return true
    } catch (e) {
        return false
    }

}
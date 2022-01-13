//Generated at 2022-01-13T13:10:12Z
function flow2(
    val
) {
const _basePath = "f1"
let _it = null, _it2 = null
let lit = []
var x =
 {value: val}
    
        _it = x

    _it = _renderReplyFetch(_basePath, "index2.ftl", false, _it)
    _it2 = JSON.parse(_it.second)
    if (_it.first.booleanValue()) return _abort(_it2)

    var data =
 _it2
    _it = null
    _it2 = null
if (    
_equals(data.something, "")
) {
_log("There was a missing value"
)
var ret =
 { success: false, error: "You forgot something!" }
    _it = ret
return _finish(_it)
}
else {
    _it = true
return _finish(_it)
}

}

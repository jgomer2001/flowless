//Generated at 2022-02-01T16:27:18Z
function flow1(
) {
const _basePath = "f1"
let _it = null, _it2 = null
let idx = [], _items = []
    
        _it = {}

    _it = _renderReplyFetch(_basePath, "index.ftl", false, _it)
    _it2 = JSON.parse(_it.second)
    if (_it.first.booleanValue()) return _abort(_it2)

    var data =
 _it2
    _it = null
    _it2 = null
        it = "org.gluu.flow2"
var data =
_flowCall(it, _basePath, [  ], [ data.secret[_ic(0, "0")] ])
_log([ "@debug Subflow finished successfully?", data.success ])
    _it = data
return _finish(_it)

}

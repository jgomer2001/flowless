//Generated at 2022-01-13T13:09:00Z
function flow1(
) {
const _basePath = "f1"
let _it = null, _it2 = null
let lit = []
    
        _it = {}

    _it = _renderReplyFetch(_basePath, "index.ftl", false, _it)
    _it2 = JSON.parse(_it.second)
    if (_it.first.booleanValue()) return _abort(_it2)

    var data =
 _it2
    _it = null
    _it2 = null
var data =
_flowCall(_basePath, []
, 
    "org.gluu.flow2", ""

, data.secret[0]
)
_log("@debug Subflow finished successfully?", data.success
)
    _it = data
return _finish(_it)

}

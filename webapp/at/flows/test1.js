function main_test1(
) {
const _basePath = "t1"
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
var name =
 data.name
_log([ "Hey", name ])
var params =
 { nick: name, 
    instruments: [ "piano", "bass guitar", "electric guitar", "drums" ]}
    
        _it = params

    _it = _renderReplyFetch(_basePath, "test/inst.ftl", false, _it)
    _it2 = JSON.parse(_it.second)
    if (_it.first.booleanValue()) return _abort(_it2)

    var data =
 _it2
    _it = null
    _it2 = null
if (    !
_equals(data.favorite, "drums")
||
    
_equals(name, "jose")
) {
    _it = true
return _finish(_it)
}
else {
_log([ "Bye, bye", name ])
var output =
 { success: false, error: "We decided not to let you in ☺, period." }
    _it = output
return _finish(_it)
}

}

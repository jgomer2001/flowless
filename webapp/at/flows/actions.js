function actions(
) {
const _basePath = ""
let _it = null, _it2 = null
let idx = [], _items = []
var l =
 [ 1, 2, 3, 4 ]

    var sum =
 _actionCall(
        null, false, "org.gluu.flowless.Utils"
, "myMethod", [ l ]    )

_log([ "result is", sum ])

    var small =
 _actionCall(
        null, false, "java.util.Collections"
, "min", [ l ]    )

_log([ "min element is", small ])
var name =
 "org.gluu.flowless.Utils"

    var sum =
 _actionCall(
        null, false, name
, "myMethod", [ l ]    )

_log([ "result is", sum ])

    var str =
 _actionCall(
        null, false, "org.gluu.flowless.Utils"
, "aString", [  ]    )


    var len =
 _actionCall(
        str, true, null
, "length", [  ]    )

_log([ "len is %", len ])

    var char =
 _actionCall(
        str, true, null
, "charAt", [ 3 ]    )

_log([ "4th char is", char ])
    _it = true
return _finish(_it)

}

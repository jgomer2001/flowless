<#ftl output_format="JavaScript">

let _imp = JavaImporter(
    Packages.org.gluu.flowless.engine.misc.FlowUtils
)

with (_imp) {

function RenderReplyFetch(base, page, data) {
    let jsonStr = FlowUtils.pauseFlow(base + "/" + page, data)
    return JSON.parse(jsonStr)
}

${fun}

}

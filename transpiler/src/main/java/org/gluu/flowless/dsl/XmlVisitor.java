package org.gluu.flowless.dsl;

import java.util.ArrayList;
import java.util.List;
import net.sf.saxon.sapling.SaplingElement;
import net.sf.saxon.sapling.Saplings;
import net.sf.saxon.sapling.SaplingNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.gluu.flowless.antlr.AuthnFlowBaseVisitor;
import org.gluu.flowless.antlr.AuthnFlowParser;

public class XmlVisitor extends AuthnFlowBaseVisitor<SaplingElement> {
    private static List<SaplingElement> emptyList() {
        return new ArrayList();
    }

    private static String getRuleName(ParserRuleContext ctx) {
        return AuthnFlowParser.ruleNames[ctx.getRuleIndex()];
    }

    private static SaplingElement simpleElem(ParserRuleContext ctx) {
        return Saplings.elem(getRuleName(ctx));
    }

    private static SaplingElement elemText(ParserRuleContext ctx) {
        return simpleElem(ctx).withText(ctx.getText());
    }

    private static SaplingElement elem(ParserRuleContext ctx, List<SaplingElement> children) {
        return simpleElem(ctx).withChild(children.toArray(new SaplingNode[]{}));
    }

    private void visitAndAdd(ParserRuleContext ctx, List<SaplingElement> elements) {
        if (ctx != null) {
            elements.add(visit(ctx));
        }
    }

    @Override
    public SaplingElement visitFlow(AuthnFlowParser.FlowContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.header(), children);
        ctx.statement().forEach(st -> visitAndAdd(st, children));

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitHeader(AuthnFlowParser.HeaderContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.qname(), children);
        visitAndAdd(ctx.inputs(), children);

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitQname(AuthnFlowParser.QnameContext ctx) {
        return elemText(ctx);
    }

    @Override
    public SaplingElement visitInputs(AuthnFlowParser.InputsContext ctx) {

        List<SaplingElement> children = emptyList();
        ctx.param().forEach(p -> visitAndAdd(p, children));

        return elem(ctx, children);
    }

    @Override
    public SaplingElement visitParam(AuthnFlowParser.ParamContext ctx) {
        return simpleElem(ctx).withText(ctx.ALPHANUM().getText());
    }

    @Override
    public SaplingElement visitStatement(AuthnFlowParser.StatementContext ctx) {
        return visit(ctx.children.get(0));
    }

    @Override
    public SaplingElement visitAssignment(AuthnFlowParser.AssignmentContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.variable(), children);
        visitAndAdd(ctx.expression(), children);

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitVariable(AuthnFlowParser.VariableContext ctx) {
        return elemText(ctx);
    }

    @Override
    public SaplingElement visitExpression(AuthnFlowParser.ExpressionContext ctx) {
        return elemText(ctx);
    }

    @Override
    public SaplingElement visitSimple_expr(AuthnFlowParser.Simple_exprContext ctx) {
        return elemText(ctx);
    }

    @Override
    public SaplingElement visitLoop(AuthnFlowParser.LoopContext ctx) {

        List<SaplingElement> children = emptyList();
        ctx.statement().forEach(st -> visitAndAdd(st, children));
        visitAndAdd(ctx.quit_stmt(), children);

        return elem(ctx, children).withAttr(ctx.TRYTIMES().getText(), ctx.simple_expr().getText());

    }

    public SaplingElement visitQuit_stmt(AuthnFlowParser.Quit_stmtContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.caseof(), children);
        visitAndAdd(ctx.elseblock(), children);

        return elem(ctx, children);
    }

    @Override
    public SaplingElement visitLog(AuthnFlowParser.LogContext ctx) {

        List<SaplingElement> children = emptyList();
        ctx.argument().forEach(st -> visitAndAdd(st, children));
        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitArgument(AuthnFlowParser.ArgumentContext ctx) {
        return simpleElem(ctx).withText(ctx.simple_expr().getText());
    }

    @Override
    public SaplingElement visitAccept(AuthnFlowParser.AcceptContext ctx) {

        /*
        // Ugly Java: the orElse is evaluated even if the Optional is present!
        Optional.ofNullable(ctx.STRING()).map(TerminalNode::getText)
                .orElse(ctx.object_expr().getText());
         */
        String text = ctx.STRING() != null
                ? ctx.STRING().getText() : ctx.object_expr().getText();
        return simpleElem(ctx).withText(text);

    }

    @Override
    public SaplingElement visitReject(AuthnFlowParser.RejectContext ctx) {

        //Same logic as in visitAccept:
        String text = ctx.STRING() != null
                ? ctx.STRING().getText() : ctx.object_expr().getText();
        return simpleElem(ctx).withText(text);

    }

    @Override
    public SaplingElement visitIfelse(AuthnFlowParser.IfelseContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.caseof(), children);
        ctx.statement().forEach(st -> visitAndAdd(st, children));
        visitAndAdd(ctx.elseblock(), children);

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitCaseof(AuthnFlowParser.CaseofContext ctx) {

        List<SaplingElement> children = emptyList();
        ctx.simple_expr().forEach(expr -> visitAndAdd(expr, children));

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitElseblock(AuthnFlowParser.ElseblockContext ctx) {

        List<SaplingElement> children = emptyList();
        ctx.statement().forEach(st -> visitAndAdd(st, children));

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitChoice(AuthnFlowParser.ChoiceContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.simple_expr(), children);
        ctx.option().forEach(st -> visitAndAdd(st, children));
        visitAndAdd(ctx.elseblock(), children);

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitOption(AuthnFlowParser.OptionContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.simple_expr(), children);
        ctx.statement().forEach(st -> visitAndAdd(st, children));

        return elem(ctx, children);

    }

    @Override
    public SaplingElement visitInvocation(AuthnFlowParser.InvocationContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.variable(), children);

        String childRuleName;
        if (ctx.flow_call() != null) {
            AuthnFlowParser.Flow_callContext ctx2 = ctx.flow_call();
            visitAndAdd(ctx2.call(), children);
            childRuleName = getRuleName(ctx2);
        } else {
            AuthnFlowParser.Task_callContext ctx2 = ctx.task_call();
            visitAndAdd(ctx2.call(), children);
            childRuleName = getRuleName(ctx2);
        }

        return elem(ctx, children).withAttr("type", childRuleName);

    }

    @Override
    public SaplingElement visitCall(AuthnFlowParser.CallContext ctx) {

        List<SaplingElement> children = emptyList();
        visitAndAdd(ctx.qname(), children);
        ctx.argument().forEach(st -> visitAndAdd(st, children));

        return elem(ctx, children);

    }

}

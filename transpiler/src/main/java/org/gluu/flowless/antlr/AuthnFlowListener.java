// Generated from AuthnFlow.g4 by ANTLR 4.9.2
package org.gluu.flowless.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AuthnFlowParser}.
 */
public interface AuthnFlowListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterFlow(AuthnFlowParser.FlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitFlow(AuthnFlowParser.FlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#qname}.
	 * @param ctx the parse tree
	 */
	void enterQname(AuthnFlowParser.QnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#qname}.
	 * @param ctx the parse tree
	 */
	void exitQname(AuthnFlowParser.QnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(AuthnFlowParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(AuthnFlowParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(AuthnFlowParser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(AuthnFlowParser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(AuthnFlowParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(AuthnFlowParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AuthnFlowParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AuthnFlowParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(AuthnFlowParser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(AuthnFlowParser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(AuthnFlowParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(AuthnFlowParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#flow_call}.
	 * @param ctx the parse tree
	 */
	void enterFlow_call(AuthnFlowParser.Flow_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#flow_call}.
	 * @param ctx the parse tree
	 */
	void exitFlow_call(AuthnFlowParser.Flow_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#task_call}.
	 * @param ctx the parse tree
	 */
	void enterTask_call(AuthnFlowParser.Task_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#task_call}.
	 * @param ctx the parse tree
	 */
	void exitTask_call(AuthnFlowParser.Task_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(AuthnFlowParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(AuthnFlowParser.LogContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(AuthnFlowParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(AuthnFlowParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(AuthnFlowParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(AuthnFlowParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expr(AuthnFlowParser.Simple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expr(AuthnFlowParser.Simple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(AuthnFlowParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(AuthnFlowParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AuthnFlowParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AuthnFlowParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void enterArray_expr(AuthnFlowParser.Array_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void exitArray_expr(AuthnFlowParser.Array_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#object_expr}.
	 * @param ctx the parse tree
	 */
	void enterObject_expr(AuthnFlowParser.Object_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#object_expr}.
	 * @param ctx the parse tree
	 */
	void exitObject_expr(AuthnFlowParser.Object_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AuthnFlowParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AuthnFlowParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#keypair}.
	 * @param ctx the parse tree
	 */
	void enterKeypair(AuthnFlowParser.KeypairContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#keypair}.
	 * @param ctx the parse tree
	 */
	void exitKeypair(AuthnFlowParser.KeypairContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#accept}.
	 * @param ctx the parse tree
	 */
	void enterAccept(AuthnFlowParser.AcceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#accept}.
	 * @param ctx the parse tree
	 */
	void exitAccept(AuthnFlowParser.AcceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#reject}.
	 * @param ctx the parse tree
	 */
	void enterReject(AuthnFlowParser.RejectContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#reject}.
	 * @param ctx the parse tree
	 */
	void exitReject(AuthnFlowParser.RejectContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(AuthnFlowParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(AuthnFlowParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(AuthnFlowParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(AuthnFlowParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(AuthnFlowParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(AuthnFlowParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#caseof}.
	 * @param ctx the parse tree
	 */
	void enterCaseof(AuthnFlowParser.CaseofContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#caseof}.
	 * @param ctx the parse tree
	 */
	void exitCaseof(AuthnFlowParser.CaseofContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#elseblock}.
	 * @param ctx the parse tree
	 */
	void enterElseblock(AuthnFlowParser.ElseblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#elseblock}.
	 * @param ctx the parse tree
	 */
	void exitElseblock(AuthnFlowParser.ElseblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(AuthnFlowParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(AuthnFlowParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuthnFlowParser#quit_stmt}.
	 * @param ctx the parse tree
	 */
	void enterQuit_stmt(AuthnFlowParser.Quit_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuthnFlowParser#quit_stmt}.
	 * @param ctx the parse tree
	 */
	void exitQuit_stmt(AuthnFlowParser.Quit_stmtContext ctx);
}
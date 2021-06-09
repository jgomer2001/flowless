// Generated from AuthnFlow.g4 by ANTLR 4.9.2
package org.gluu.flowless.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AuthnFlowParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AuthnFlowVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow(AuthnFlowParser.FlowContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#qname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQname(AuthnFlowParser.QnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(AuthnFlowParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(AuthnFlowParser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(AuthnFlowParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AuthnFlowParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvocation(AuthnFlowParser.InvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AuthnFlowParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#flow_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_call(AuthnFlowParser.Flow_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#task_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTask_call(AuthnFlowParser.Task_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(AuthnFlowParser.LogContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(AuthnFlowParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(AuthnFlowParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#simple_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expr(AuthnFlowParser.Simple_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AuthnFlowParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AuthnFlowParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#array_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_expr(AuthnFlowParser.Array_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#object_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_expr(AuthnFlowParser.Object_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AuthnFlowParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#keypair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeypair(AuthnFlowParser.KeypairContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#accept}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccept(AuthnFlowParser.AcceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#reject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReject(AuthnFlowParser.RejectContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(AuthnFlowParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(AuthnFlowParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#ifelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(AuthnFlowParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#caseof}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseof(AuthnFlowParser.CaseofContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#elseblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseblock(AuthnFlowParser.ElseblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(AuthnFlowParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuthnFlowParser#quit_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuit_stmt(AuthnFlowParser.Quit_stmtContext ctx);
}
package xdi2.messaging.target.impl.graph;

import xdi2.core.ContextNode;
import xdi2.core.Graph;
import xdi2.core.Literal;
import xdi2.core.Relation;
import xdi2.core.exceptions.Xdi2MessagingException;
import xdi2.core.util.CopyUtil;
import xdi2.core.util.XDIConstants;
import xdi2.core.variables.VariablesUtil;
import xdi2.core.xri3.impl.XRI3Segment;
import xdi2.messaging.MessageResult;
import xdi2.messaging.Operation;
import xdi2.messaging.target.ExecutionContext;

public class RelationResourceHandler extends AbstractGraphResourceHandler {

	RelationResourceHandler(Operation operation, Relation operationRelation, Graph graph) {

		super(operation, operationRelation, graph);
	}

	@Override
	public boolean executeAdd(Operation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XRI3Segment operationContextNodeXri = this.operationRelation.getContextNode().getXri();
		ContextNode contextNode = this.graph.findContextNode(operationContextNodeXri, true);

		contextNode.createRelation(this.operationRelation.getArcXri(), this.operationRelation.getRelationXri());

		return true;
	}

	@Override
	public boolean executeGet(Operation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XRI3Segment operationContextNodeXri = this.operationRelation.getContextNode().getXri();
		ContextNode contextNode = this.graph.findContextNode(operationContextNodeXri, false);
		if (contextNode == null) return true;

		boolean isRelationXriVariable = VariablesUtil.isVariable(this.operationRelation.getRelationXri());
		
		if (this.operationRelation.getArcXri().equals(XDIConstants.XRI_S_LITERAL)) {

			if (isRelationXriVariable) {

				Literal literal = contextNode.getLiteral();
				if (literal == null) return true;

				CopyUtil.copyLiteral(literal, messageResult.getGraph(), null);
			}
		} else {

			Relation relation = contextNode.getRelation(this.operationRelation.getArcXri());
			if (relation == null) return true;

			if (isRelationXriVariable || this.operationRelation.getRelationXri().equals(relation.getRelationXri())) {

				CopyUtil.copyRelation(relation, messageResult.getGraph(), null);
			}
		}

		return true;
	}

	@Override
	public boolean executeDel(Operation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XRI3Segment operationContextNodeXri = this.operationRelation.getContextNode().getXri();
		ContextNode contextNode = this.graph.findContextNode(operationContextNodeXri, false);
		if (contextNode == null) return true;

		Relation relation = contextNode.getRelation(this.operationRelation.getArcXri());
		if (relation == null) return true;

		if (VariablesUtil.isVariable(this.operationRelation.getRelationXri()) ||
				this.operationRelation.getRelationXri().equals(relation.getRelationXri())) {

			relation.delete();
		}

		return true;
	}
}

package com.oracle.truffle.js.nodes;

@com.oracle.truffle.api.dsl.GeneratedBy(com.oracle.truffle.js.nodes.NodeFactory.class)
public class NodeFactoryDecoderGen implements com.oracle.truffle.js.codec.NodeDecoder<com.oracle.truffle.js.nodes.NodeFactory> {
private NodeFactoryDecoderGen() {
}

public static NodeFactoryDecoderGen create() {
return new NodeFactoryDecoderGen();
}

private static final Class<?>[] CLASSES = {int.class, com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation.class, com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation.class, com.oracle.truffle.js.runtime.JSErrorType.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode.class};

@Override
public Class<?>[] getClasses() {
return CLASSES;
}

@Override
@SuppressWarnings("unchecked")
public Object decodeNode(DecoderState decoder, com.oracle.truffle.js.nodes.NodeFactory nodeFactory) {
switch (decoder.getUInt()) {
case 0:
return nodeFactory.createUnary((com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 1:
return nodeFactory.createToNumeric((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 2:
return nodeFactory.createDual((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 3:
return nodeFactory.createBinary((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 4:
return nodeFactory.createTypeofIdentical((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject());
case 5:
return nodeFactory.createLogicalOr((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 6:
return nodeFactory.createNotUndefinedOr((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 7:
return nodeFactory.createConstant(decoder.getObject());
case 8:
return nodeFactory.createConstantBoolean((boolean)decoder.getObject());
case 9:
return nodeFactory.createConstantInteger((int)decoder.getObject());
case 10:
return nodeFactory.createConstantSafeInteger((long)decoder.getObject());
case 11:
return nodeFactory.createConstantNumericUnit();
case 12:
return nodeFactory.createConstantDouble((double)decoder.getObject());
case 13:
return nodeFactory.createConstantString((java.lang.String)decoder.getObject());
case 14:
return nodeFactory.createConstantUndefined();
case 15:
return nodeFactory.createConstantNull();
case 16:
return nodeFactory.createIf((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 17:
return nodeFactory.createSwitch((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject(), (int[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 18:
return nodeFactory.createWhileDo((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 19:
return nodeFactory.createDoWhile((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 20:
return nodeFactory.createDesugaredFor((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 21:
return nodeFactory.createDesugaredForOf((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 22:
return nodeFactory.createDesugaredForIn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 23:
return nodeFactory.createDesugaredForAwaitOf((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 24:
return nodeFactory.createFor((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 25:
return nodeFactory.createIterationScope((com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject());
case 26:
return nodeFactory.createBreak((com.oracle.truffle.js.nodes.control.BreakTarget)decoder.getObject());
case 27:
return nodeFactory.createContinue((com.oracle.truffle.js.nodes.control.ContinueTarget)decoder.getObject());
case 28:
return nodeFactory.createLabel((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.BreakTarget)decoder.getObject());
case 29:
return nodeFactory.createEmpty();
case 30:
return nodeFactory.createVoidBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 31:
return nodeFactory.createExprBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 32:
return nodeFactory.createReturnTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 33:
return nodeFactory.createFrameReturnTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 34:
return nodeFactory.createContinueTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ContinueTarget)decoder.getObject());
case 35:
return nodeFactory.createDirectBreakTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 36:
return nodeFactory.createDebugger();
case 37:
return nodeFactory.createLocal((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot[])decoder.getObject());
case 38:
return nodeFactory.createLocal((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot[])decoder.getObject(), (boolean)decoder.getObject());
case 39:
return nodeFactory.createWriteFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 40:
return nodeFactory.createWriteFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 41:
return nodeFactory.createReadLexicalGlobal((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 42:
return nodeFactory.createGlobalScope((com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 43:
return nodeFactory.createGlobalScopeTDZCheck((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 44:
return nodeFactory.createGlobalVarWrapper((java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSTargetableNode)decoder.getObject());
case 45:
return nodeFactory.createThrow((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 46:
return nodeFactory.createTryCatch((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.function.BlockScopeNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 47:
return nodeFactory.createTryFinally((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 48:
return nodeFactory.createFunctionCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 49:
return nodeFactory.createFunctionCallWithNewTarget((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 50:
return nodeFactory.createNew((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 51:
return nodeFactory.createAccessThis();
case 52:
return nodeFactory.createAccessCallee((int)decoder.getObject());
case 53:
return nodeFactory.createAccessLexicalThis();
case 54:
return nodeFactory.createAccessArgument((int)decoder.getObject());
case 55:
return nodeFactory.createAccessVarArgs((int)decoder.getObject());
case 56:
return nodeFactory.createAccessRestArgument((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject());
case 57:
return nodeFactory.createAccessNewTarget();
case 58:
return nodeFactory.createAccessFrameArgument((int)decoder.getObject(), (int)decoder.getObject());
case 59:
return nodeFactory.createAccessHomeObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 60:
return nodeFactory.createReadElementNode((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 61:
return nodeFactory.createWriteElementNode((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 62:
return nodeFactory.createCompoundWriteElementNode((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 63:
return nodeFactory.createReadProperty((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject());
case 64:
return nodeFactory.createReadProperty((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 65:
return nodeFactory.createWriteProperty((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 66:
return nodeFactory.createWriteProperty((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 67:
return nodeFactory.createWriteConstantVariable((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 68:
return nodeFactory.createReadGlobalProperty((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject());
case 69:
return nodeFactory.createDeleteProperty((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 70:
return nodeFactory.createFunctionRootNode((com.oracle.truffle.js.nodes.function.AbstractBodyNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.api.source.SourceSection)decoder.getObject(), (java.lang.String)decoder.getObject());
case 71:
return nodeFactory.createConstructorRootNode((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject(), (boolean)decoder.getObject());
case 72:
return nodeFactory.createFunctionBody((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 73:
return nodeFactory.createFunctionExpression((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.js.nodes.function.FunctionRootNode)decoder.getObject());
case 74:
return nodeFactory.createFunctionExpressionLexicalThis((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.js.nodes.function.FunctionRootNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 75:
return nodeFactory.createPrepareThisBinding((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 76:
return nodeFactory.createGlobalObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 77:
return nodeFactory.createArgumentsObjectNode((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject());
case 78:
return nodeFactory.createThrowError((com.oracle.truffle.js.runtime.JSErrorType)decoder.getObject(), (java.lang.String)decoder.getObject());
case 79:
return nodeFactory.createObjectLiteral((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.util.ArrayList<com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode>)decoder.getObject());
case 80:
return nodeFactory.createArrayLiteral((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 81:
return nodeFactory.createArrayLiteralWithSpread((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 82:
return nodeFactory.createAccessorMember((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 83:
return nodeFactory.createDataMember((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 84:
return nodeFactory.createProtoMember((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 85:
return nodeFactory.createComputedDataMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject());
case 86:
return nodeFactory.createComputedAccessorMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 87:
return nodeFactory.createSpreadObjectMember((boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 88:
return nodeFactory.createClassDefinition((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode[])decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (boolean)decoder.getObject());
case 89:
return nodeFactory.createMakeMethod((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 90:
return nodeFactory.createSpreadArgument((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 91:
return nodeFactory.createSpreadArray((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 92:
return nodeFactory.createReturn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 93:
return nodeFactory.createFrameReturn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 94:
return nodeFactory.createTerminalPositionReturn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 95:
return nodeFactory.createFunctionData((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (int)decoder.getObject(), (java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject());
case 96:
return nodeFactory.createAwait((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 97:
return nodeFactory.createYield((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ReturnNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 98:
return nodeFactory.createAsyncGeneratorYield((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ReturnNode)decoder.getObject());
case 99:
return nodeFactory.createAsyncGeneratorYieldStar((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ReturnNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 100:
return nodeFactory.createAsyncFunctionBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 101:
return nodeFactory.createGeneratorBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 102:
return nodeFactory.createAsyncGeneratorBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 103:
return nodeFactory.createGeneratorWrapper((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 104:
return nodeFactory.createGeneratorVoidBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 105:
return nodeFactory.createGeneratorExprBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 106:
return nodeFactory.createLazyReadFrameSlot(decoder.getObject());
case 107:
return nodeFactory.createLazyWriteFrameSlot(decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 108:
return nodeFactory.createBlockScope((com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 109:
return nodeFactory.createTemplateObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 110:
return nodeFactory.createToString((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 111:
return nodeFactory.createRegExpLiteral((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject(), (java.lang.String)decoder.getObject());
case 112:
return nodeFactory.createGetIterator((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 113:
return nodeFactory.createGetAsyncIterator((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 114:
return nodeFactory.createEnumerate((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 115:
return nodeFactory.createIteratorNext((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 116:
return nodeFactory.createIteratorComplete((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 117:
return nodeFactory.createIteratorGetNextValue((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 118:
return nodeFactory.createIteratorSetDone((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 119:
return nodeFactory.createAsyncIteratorNext((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 120:
return nodeFactory.createIteratorValue((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 121:
return nodeFactory.createAsyncIteratorCloseWrapper((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 122:
return nodeFactory.createIteratorCloseIfNotDone((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 123:
return nodeFactory.createIteratorToArray((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 124:
return nodeFactory.createGetPrototype((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 125:
return nodeFactory.createSuperPropertyReference((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 126:
return nodeFactory.createTargetableWrapper((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 127:
return nodeFactory.createWith((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 128:
return nodeFactory.createWithVarWrapper((java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSTargetableNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 129:
return nodeFactory.createWithTarget((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 130:
return nodeFactory.createNewTargetConstruct((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject());
case 131:
return nodeFactory.createNewTargetCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject());
case 132:
return nodeFactory.createDropNewTarget((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject());
case 133:
return nodeFactory.createConstructorRequiresNewRoot((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.api.source.SourceSection)decoder.getObject());
case 134:
return nodeFactory.createDerivedConstructorResult((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 135:
return nodeFactory.createDerivedConstructorThis((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 136:
return nodeFactory.createRequireObjectCoercible((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 137:
return nodeFactory.createFrameDescriptor();
case 138:
return nodeFactory.createBlockFrameDescriptor();
case 139:
return nodeFactory.createDeclareGlobalVariable((java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 140:
return nodeFactory.createDeclareGlobalFunction((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 141:
return nodeFactory.createDeclareGlobalLexicalVariable((java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 142:
return nodeFactory.createGlobalDeclarationInstantiation((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.util.List<com.oracle.truffle.js.nodes.access.DeclareGlobalNode>)decoder.getObject());
case 143:
return nodeFactory.copy((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 144:
return nodeFactory.createToObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 145:
return nodeFactory.createToObjectFromWith((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 146:
return nodeFactory.createAccessArgumentsArrayDirectly((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject());
case 147:
return nodeFactory.createCallApplyArguments((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.function.JSFunctionCallNode)decoder.getObject());
case 148:
return nodeFactory.createGuardDisconnectedArgumentRead((int)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ReadElementNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 149:
return nodeFactory.createGuardDisconnectedArgumentWrite((int)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteElementNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 150:
return nodeFactory.createModuleBody((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 151:
return nodeFactory.createModuleYield();
case 152:
return nodeFactory.createTopLevelAsyncModuleBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 153:
return nodeFactory.createImportMeta((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 154:
return nodeFactory.createResolveStarImport((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 155:
return nodeFactory.createResolveNamedImport((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 156:
return nodeFactory.createReadImportBinding((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 157:
return nodeFactory.createImportCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 158:
return nodeFactory.createRestObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 159:
return nodeFactory.createInitializeInstanceElements((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 160:
return nodeFactory.createNewPrivateName((java.lang.String)decoder.getObject());
case 161:
return nodeFactory.createPrivateFieldGet((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 162:
return nodeFactory.createPrivateFieldSet((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 163:
return nodeFactory.createPrivateFieldMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 164:
return nodeFactory.createPrivateMethodMember((boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 165:
return nodeFactory.createPrivateAccessorMember((boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 166:
return nodeFactory.createPrivateBrandCheck((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 167:
return nodeFactory.createGetPrivateBrand((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 168:
return nodeFactory.createToPropertyKey((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 169:
return nodeFactory.createOptionalChain((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 170:
return nodeFactory.createOptionalChainShortCircuit((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 171:
return nodeFactory.copyIfWithCondition((com.oracle.truffle.js.nodes.control.IfNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
default:
throw new IllegalArgumentException("unknown node id");
}
}

@Override
public int getMethodIdFromSignature(String signature) {
return EncoderSupport.getMethodIdFromSignature(signature);
}

private static class EncoderSupport {
static int getMethodIdFromSignature(String signature) {
switch (signature) {
case "createUnary(com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 0;
case "createToNumeric(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 1;
case "createDual(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 2;
case "createBinary(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 3;
case "createTypeofIdentical(com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 4;
case "createLogicalOr(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 5;
case "createNotUndefinedOr(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 6;
case "createConstant(java.lang.Object)com.oracle.truffle.js.nodes.JavaScriptNode":
return 7;
case "createConstantBoolean(boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 8;
case "createConstantInteger(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 9;
case "createConstantSafeInteger(long)com.oracle.truffle.js.nodes.JavaScriptNode":
return 10;
case "createConstantNumericUnit()com.oracle.truffle.js.nodes.JavaScriptNode":
return 11;
case "createConstantDouble(double)com.oracle.truffle.js.nodes.JavaScriptNode":
return 12;
case "createConstantString(java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 13;
case "createConstantUndefined()com.oracle.truffle.js.nodes.JavaScriptNode":
return 14;
case "createConstantNull()com.oracle.truffle.js.nodes.JavaScriptNode":
return 15;
case "createIf(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.IfNode":
return 16;
case "createSwitch(com.oracle.truffle.js.nodes.JavaScriptNode[],int[],com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.control.SwitchNode":
return 17;
case "createWhileDo(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 18;
case "createDoWhile(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 19;
case "createDesugaredFor(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 20;
case "createDesugaredForOf(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 21;
case "createDesugaredForIn(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 22;
case "createDesugaredForAwaitOf(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 23;
case "createFor(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.StatementNode":
return 24;
case "createIterationScope(com.oracle.truffle.api.frame.FrameDescriptor)com.oracle.truffle.js.nodes.function.IterationScopeNode":
return 25;
case "createBreak(com.oracle.truffle.js.nodes.control.BreakTarget)com.oracle.truffle.js.nodes.control.BreakNode":
return 26;
case "createContinue(com.oracle.truffle.js.nodes.control.ContinueTarget)com.oracle.truffle.js.nodes.control.ContinueNode":
return 27;
case "createLabel(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.control.BreakTarget)com.oracle.truffle.js.nodes.control.LabelNode":
return 28;
case "createEmpty()com.oracle.truffle.js.nodes.JavaScriptNode":
return 29;
case "createVoidBlock(com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 30;
case "createExprBlock(com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 31;
case "createReturnTarget(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnTargetNode":
return 32;
case "createFrameReturnTarget(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnTargetNode":
return 33;
case "createContinueTarget(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.control.ContinueTarget)com.oracle.truffle.js.nodes.control.ContinueTargetNode":
return 34;
case "createDirectBreakTarget(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.DirectBreakTargetNode":
return 35;
case "createDebugger()com.oracle.truffle.js.nodes.JavaScriptNode":
return 36;
case "createLocal(com.oracle.truffle.api.frame.FrameSlot,int,int,com.oracle.truffle.api.frame.FrameSlot[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 37;
case "createLocal(com.oracle.truffle.api.frame.FrameSlot,int,int,com.oracle.truffle.api.frame.FrameSlot[],boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 38;
case "createWriteFrameSlot(com.oracle.truffle.api.frame.FrameSlot,int,int,com.oracle.truffle.api.frame.FrameSlot[],com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode":
return 39;
case "createWriteFrameSlot(com.oracle.truffle.api.frame.FrameSlot,int,int,com.oracle.truffle.api.frame.FrameSlot[],com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode":
return 40;
case "createReadLexicalGlobal(java.lang.String,boolean,com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 41;
case "createGlobalScope(com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 42;
case "createGlobalScopeTDZCheck(com.oracle.truffle.js.runtime.JSContext,java.lang.String,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 43;
case "createGlobalVarWrapper(java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSTargetableNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 44;
case "createThrow(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 45;
case "createTryCatch(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.function.BlockScopeNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 46;
case "createTryFinally(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 47;
case "createFunctionCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 48;
case "createFunctionCallWithNewTarget(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 49;
case "createNew(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 50;
case "createAccessThis()com.oracle.truffle.js.nodes.JavaScriptNode":
return 51;
case "createAccessCallee(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 52;
case "createAccessLexicalThis()com.oracle.truffle.js.nodes.JavaScriptNode":
return 53;
case "createAccessArgument(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 54;
case "createAccessVarArgs(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 55;
case "createAccessRestArgument(com.oracle.truffle.js.runtime.JSContext,int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 56;
case "createAccessNewTarget()com.oracle.truffle.js.nodes.JavaScriptNode":
return 57;
case "createAccessFrameArgument(int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 58;
case "createAccessHomeObject(com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 59;
case "createReadElementNode(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ReadElementNode":
return 60;
case "createWriteElementNode(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WriteElementNode":
return 61;
case "createCompoundWriteElementNode(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WriteElementNode":
return 62;
case "createReadProperty(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 63;
case "createReadProperty(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String,boolean)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 64;
case "createWriteProperty(com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.Object,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WritePropertyNode":
return 65;
case "createWriteProperty(com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WritePropertyNode":
return 66;
case "createWriteConstantVariable(com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.access.ConstantVariableWriteNode":
return 67;
case "createReadGlobalProperty(com.oracle.truffle.js.runtime.JSContext,java.lang.String)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 68;
case "createDeleteProperty(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 69;
case "createFunctionRootNode(com.oracle.truffle.js.nodes.function.AbstractBodyNode,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.api.source.SourceSection,java.lang.String)com.oracle.truffle.js.nodes.function.FunctionRootNode":
return 70;
case "createConstructorRootNode(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.api.CallTarget,boolean)com.oracle.truffle.js.nodes.function.ConstructorRootNode":
return 71;
case "createFunctionBody(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.function.FunctionBodyNode":
return 72;
case "createFunctionExpression(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.js.nodes.function.FunctionRootNode)com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode":
return 73;
case "createFunctionExpressionLexicalThis(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.js.nodes.function.FunctionRootNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode":
return 74;
case "createPrepareThisBinding(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 75;
case "createGlobalObject(com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 76;
case "createArgumentsObjectNode(com.oracle.truffle.js.runtime.JSContext,boolean,int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 77;
case "createThrowError(com.oracle.truffle.js.runtime.JSErrorType,java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 78;
case "createObjectLiteral(com.oracle.truffle.js.runtime.JSContext,java.util.ArrayList)com.oracle.truffle.js.nodes.JavaScriptNode":
return 79;
case "createArrayLiteral(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 80;
case "createArrayLiteralWithSpread(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 81;
case "createAccessorMember(java.lang.String,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 82;
case "createDataMember(java.lang.String,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 83;
case "createProtoMember(java.lang.String,boolean,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 84;
case "createComputedDataMember(com.oracle.truffle.js.nodes.JavaScriptNode,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,boolean)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 85;
case "createComputedAccessorMember(com.oracle.truffle.js.nodes.JavaScriptNode,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 86;
case "createSpreadObjectMember(boolean,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 87;
case "createClassDefinition(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode[],com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,java.lang.String,int,int,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 88;
case "createMakeMethod(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 89;
case "createSpreadArgument(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 90;
case "createSpreadArray(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 91;
case "createReturn(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnNode":
return 92;
case "createFrameReturn(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnNode":
return 93;
case "createTerminalPositionReturn(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnNode":
return 94;
case "createFunctionData(com.oracle.truffle.js.runtime.JSContext,int,java.lang.String,boolean,boolean,boolean,boolean,boolean,boolean,boolean,boolean,boolean,boolean)com.oracle.truffle.js.runtime.builtins.JSFunctionData":
return 95;
case "createAwait(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 96;
case "createYield(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.nodes.control.ReturnNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 97;
case "createAsyncGeneratorYield(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.control.ReturnNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 98;
case "createAsyncGeneratorYieldStar(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.control.ReturnNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 99;
case "createAsyncFunctionBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 100;
case "createGeneratorBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 101;
case "createAsyncGeneratorBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 102;
case "createGeneratorWrapper(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 103;
case "createGeneratorVoidBlock(com.oracle.truffle.js.nodes.JavaScriptNode[],com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 104;
case "createGeneratorExprBlock(com.oracle.truffle.js.nodes.JavaScriptNode[],com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 105;
case "createLazyReadFrameSlot(java.lang.Object)com.oracle.truffle.js.nodes.access.LazyReadFrameSlotNode":
return 106;
case "createLazyWriteFrameSlot(java.lang.Object,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.LazyWriteFrameSlotNode":
return 107;
case "createBlockScope(com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 108;
case "createTemplateObject(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 109;
case "createToString(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 110;
case "createRegExpLiteral(com.oracle.truffle.js.runtime.JSContext,java.lang.String,java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 111;
case "createGetIterator(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 112;
case "createGetAsyncIterator(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 113;
case "createEnumerate(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 114;
case "createIteratorNext(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 115;
case "createIteratorComplete(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 116;
case "createIteratorGetNextValue(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 117;
case "createIteratorSetDone(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 118;
case "createAsyncIteratorNext(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 119;
case "createIteratorValue(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 120;
case "createAsyncIteratorCloseWrapper(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 121;
case "createIteratorCloseIfNotDone(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 122;
case "createIteratorToArray(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.IteratorToArrayNode":
return 123;
case "createGetPrototype(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 124;
case "createSuperPropertyReference(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 125;
case "createTargetableWrapper(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 126;
case "createWith(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 127;
case "createWithVarWrapper(java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSTargetableNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 128;
case "createWithTarget(com.oracle.truffle.js.runtime.JSContext,java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 129;
case "createNewTargetConstruct(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.api.CallTarget)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 130;
case "createNewTargetCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.api.CallTarget)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 131;
case "createDropNewTarget(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.api.CallTarget)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 132;
case "createConstructorRequiresNewRoot(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.api.source.SourceSection)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 133;
case "createDerivedConstructorResult(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 134;
case "createDerivedConstructorThis(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 135;
case "createRequireObjectCoercible(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 136;
case "createFrameDescriptor()com.oracle.truffle.api.frame.FrameDescriptor":
return 137;
case "createBlockFrameDescriptor()com.oracle.truffle.api.frame.FrameDescriptor":
return 138;
case "createDeclareGlobalVariable(java.lang.String,boolean)com.oracle.truffle.js.nodes.access.DeclareGlobalNode":
return 139;
case "createDeclareGlobalFunction(java.lang.String,boolean,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.DeclareGlobalNode":
return 140;
case "createDeclareGlobalLexicalVariable(java.lang.String,boolean)com.oracle.truffle.js.nodes.access.DeclareGlobalNode":
return 141;
case "createGlobalDeclarationInstantiation(com.oracle.truffle.js.runtime.JSContext,java.util.List)com.oracle.truffle.js.nodes.JavaScriptNode":
return 142;
case "copy(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 143;
case "createToObject(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 144;
case "createToObjectFromWith(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 145;
case "createAccessArgumentsArrayDirectly(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 146;
case "createCallApplyArguments(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.function.JSFunctionCallNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 147;
case "createGuardDisconnectedArgumentRead(int,com.oracle.truffle.js.nodes.access.ReadElementNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.JavaScriptNode":
return 148;
case "createGuardDisconnectedArgumentWrite(int,com.oracle.truffle.js.nodes.access.WriteElementNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.JavaScriptNode":
return 149;
case "createModuleBody(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 150;
case "createModuleYield()com.oracle.truffle.js.nodes.JavaScriptNode":
return 151;
case "createTopLevelAsyncModuleBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 152;
case "createImportMeta(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 153;
case "createResolveStarImport(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 154;
case "createResolveNamedImport(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String,java.lang.String,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 155;
case "createReadImportBinding(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 156;
case "createImportCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 157;
case "createRestObject(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 158;
case "createInitializeInstanceElements(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 159;
case "createNewPrivateName(java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 160;
case "createPrivateFieldGet(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 161;
case "createPrivateFieldSet(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 162;
case "createPrivateFieldMember(com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 163;
case "createPrivateMethodMember(boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 164;
case "createPrivateAccessorMember(boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 165;
case "createPrivateBrandCheck(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 166;
case "createGetPrivateBrand(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 167;
case "createToPropertyKey(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 168;
case "createOptionalChain(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 169;
case "createOptionalChainShortCircuit(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 170;
case "copyIfWithCondition(com.oracle.truffle.js.nodes.control.IfNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.IfNode":
return 171;
default:
throw new IllegalArgumentException("unknown method: " + signature);
}
}
}

@Override
public int getChecksum() {
return 1749824696;
}
}

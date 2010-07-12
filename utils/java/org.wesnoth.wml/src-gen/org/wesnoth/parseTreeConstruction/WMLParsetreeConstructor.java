/*
* generated by Xtext
*/
package org.wesnoth.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.wesnoth.services.WMLGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class WMLParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private WMLGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLRoot_Alternatives(this, this, 0, inst);
			case 1: return new WMLMacro_Group(this, this, 1, inst);
			case 2: return new WMLTag_Group(this, this, 2, inst);
			case 3: return new WMLEndTag_Group(this, this, 3, inst);
			case 4: return new WMLKey_Group(this, this, 4, inst);
			case 5: return new WMLKeyValue_Alternatives(this, this, 5, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule WMLRoot ****************
 *
 * WMLRoot:
 * 	(Rtags+=WMLTag | Rmacros+=WMLMacro)*;
 *
 **/

// (Rtags+=WMLTag | Rmacros+=WMLMacro)*
protected class WMLRoot_Alternatives extends AlternativesToken {

	public WMLRoot_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getWMLRootAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLRoot_RtagsAssignment_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new WMLRoot_RmacrosAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// Rtags+=WMLTag
protected class WMLRoot_RtagsAssignment_0 extends AssignmentToken  {
	
	public WMLRoot_RtagsAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLRootAccess().getRtagsAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLTag_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("Rtags",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("Rtags");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLTagRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLRootAccess().getRtagsWMLTagParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLRoot_Alternatives(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

// Rmacros+=WMLMacro
protected class WMLRoot_RmacrosAssignment_1 extends AssignmentToken  {
	
	public WMLRoot_RmacrosAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLRootAccess().getRmacrosAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("Rmacros",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("Rmacros");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLMacroRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLRootAccess().getRmacrosWMLMacroParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLRoot_Alternatives(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}


/************ end Rule WMLRoot ****************/


/************ begin Rule WMLMacro ****************
 *
 * WMLMacro:
 * 	"{" macroName=ID tagcontent+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")* "}";
 *
 **/

// "{" macroName=ID tagcontent+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")* "}"
protected class WMLMacro_Group extends GroupToken {
	
	public WMLMacro_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getWMLMacroAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_RightCurlyBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWMLMacroRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "{"
protected class WMLMacro_LeftCurlyBracketKeyword_0 extends KeywordToken  {
	
	public WMLMacro_LeftCurlyBracketKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLMacroAccess().getLeftCurlyBracketKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// macroName=ID
protected class WMLMacro_MacroNameAssignment_1 extends AssignmentToken  {
	
	public WMLMacro_MacroNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLMacroAccess().getMacroNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_LeftCurlyBracketKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("macroName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("macroName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getMacroNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLMacroAccess().getMacroNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// tagcontent+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")*
protected class WMLMacro_TagcontentAssignment_2 extends AssignmentToken  {
	
	public WMLMacro_TagcontentAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLMacroAccess().getTagcontentAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_TagcontentAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new WMLMacro_MacroNameAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tagcontent",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tagcontent");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontent_Keyword_2_0_2(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontent_Keyword_2_0_2();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentColonKeyword_2_0_3(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentColonKeyword_2_0_3();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentHyphenMinusKeyword_2_0_4(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentHyphenMinusKeyword_2_0_4();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentFullStopKeyword_2_0_5(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentFullStopKeyword_2_0_5();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentLeftParenthesisKeyword_2_0_6(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentLeftParenthesisKeyword_2_0_6();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentRightParenthesisKeyword_2_0_7(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentRightParenthesisKeyword_2_0_7();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentEqualsSignKeyword_2_0_8(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentEqualsSignKeyword_2_0_8();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentSolidusKeyword_2_0_9(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getWMLMacroAccess().getTagcontentSolidusKeyword_2_0_9();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentIDTerminalRuleCall_2_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLMacroAccess().getTagcontentIDTerminalRuleCall_2_0_0();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLMacroAccess().getTagcontentSTRINGTerminalRuleCall_2_0_1(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLMacroAccess().getTagcontentSTRINGTerminalRuleCall_2_0_1();
			return obj;
		}
		return null;
	}

}

// "}"
protected class WMLMacro_RightCurlyBracketKeyword_3 extends KeywordToken  {
	
	public WMLMacro_RightCurlyBracketKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLMacroAccess().getRightCurlyBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_TagcontentAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new WMLMacro_MacroNameAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule WMLMacro ****************/


/************ begin Rule WMLTag ****************
 *
 * WMLTag:
 * 	"[" name=ID "]" (Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)* end=WMLEndTag;
 *
 **/

// "[" name=ID "]" (Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)* end=WMLEndTag
protected class WMLTag_Group extends GroupToken {
	
	public WMLTag_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLTag_EndAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWMLTagRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "["
protected class WMLTag_LeftSquareBracketKeyword_0 extends KeywordToken  {
	
	public WMLTag_LeftSquareBracketKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getLeftSquareBracketKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// name=ID
protected class WMLTag_NameAssignment_1 extends AssignmentToken  {
	
	public WMLTag_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLTag_LeftSquareBracketKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLTagAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLTagAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// "]"
protected class WMLTag_RightSquareBracketKeyword_2 extends KeywordToken  {
	
	public WMLTag_RightSquareBracketKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getRightSquareBracketKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLTag_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// (Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)*
protected class WMLTag_Alternatives_3 extends AlternativesToken {

	public WMLTag_Alternatives_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getAlternatives_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLTag_TtagsAssignment_3_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new WMLTag_TkeysAssignment_3_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new WMLTag_TmacrosAssignment_3_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}

// Ttags+=WMLTag
protected class WMLTag_TtagsAssignment_3_0 extends AssignmentToken  {
	
	public WMLTag_TtagsAssignment_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getTtagsAssignment_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLTag_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("Ttags",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("Ttags");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLTagRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLTagAccess().getTtagsWMLTagParserRuleCall_3_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLTag_Alternatives_3(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new WMLTag_RightSquareBracketKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// Tkeys+=WMLKey
protected class WMLTag_TkeysAssignment_3_1 extends AssignmentToken  {
	
	public WMLTag_TkeysAssignment_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getTkeysAssignment_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLKey_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("Tkeys",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("Tkeys");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLKeyRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLTagAccess().getTkeysWMLKeyParserRuleCall_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLTag_Alternatives_3(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new WMLTag_RightSquareBracketKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// Tmacros+=WMLMacro
protected class WMLTag_TmacrosAssignment_3_2 extends AssignmentToken  {
	
	public WMLTag_TmacrosAssignment_3_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getTmacrosAssignment_3_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("Tmacros",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("Tmacros");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLMacroRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLTagAccess().getTmacrosWMLMacroParserRuleCall_3_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLTag_Alternatives_3(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new WMLTag_RightSquareBracketKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// end=WMLEndTag
protected class WMLTag_EndAssignment_4 extends AssignmentToken  {
	
	public WMLTag_EndAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLTagAccess().getEndAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLEndTag_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("end",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("end");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLEndTagRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLTagAccess().getEndWMLEndTagParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLTag_Alternatives_3(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new WMLTag_RightSquareBracketKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule WMLTag ****************/


/************ begin Rule WMLEndTag ****************
 *
 * //WMLStartTag:
 * //	'[' name = ID ']'
 * //	;
 * WMLEndTag:
 * 	"[/" tagname=ID "]";
 *
 **/

// "[/" tagname=ID "]"
protected class WMLEndTag_Group extends GroupToken {
	
	public WMLEndTag_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getWMLEndTagAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLEndTag_RightSquareBracketKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWMLEndTagRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "[/"
protected class WMLEndTag_LeftSquareBracketSolidusKeyword_0 extends KeywordToken  {
	
	public WMLEndTag_LeftSquareBracketSolidusKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLEndTagAccess().getLeftSquareBracketSolidusKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// tagname=ID
protected class WMLEndTag_TagnameAssignment_1 extends AssignmentToken  {
	
	public WMLEndTag_TagnameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLEndTagAccess().getTagnameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLEndTag_LeftSquareBracketSolidusKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tagname",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tagname");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLEndTagAccess().getTagnameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLEndTagAccess().getTagnameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// "]"
protected class WMLEndTag_RightSquareBracketKeyword_2 extends KeywordToken  {
	
	public WMLEndTag_RightSquareBracketKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLEndTagAccess().getRightSquareBracketKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLEndTag_TagnameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule WMLEndTag ****************/


/************ begin Rule WMLKey ****************
 *
 * WMLKey:
 * 	keyName=ID "=" value=WMLKeyValue;
 *
 **/

// keyName=ID "=" value=WMLKeyValue
protected class WMLKey_Group extends GroupToken {
	
	public WMLKey_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getWMLKeyAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLKey_ValueAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWMLKeyRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// keyName=ID
protected class WMLKey_KeyNameAssignment_0 extends AssignmentToken  {
	
	public WMLKey_KeyNameAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLKeyAccess().getKeyNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("keyName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("keyName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyAccess().getKeyNameIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLKeyAccess().getKeyNameIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// "="
protected class WMLKey_EqualsSignKeyword_1 extends KeywordToken  {
	
	public WMLKey_EqualsSignKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWMLKeyAccess().getEqualsSignKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLKey_KeyNameAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// value=WMLKeyValue
protected class WMLKey_ValueAssignment_2 extends AssignmentToken  {
	
	public WMLKey_ValueAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLKeyAccess().getValueAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLKeyValue_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLKeyValueRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLKeyAccess().getValueWMLKeyValueParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WMLKey_EqualsSignKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule WMLKey ****************/


/************ begin Rule WMLKeyValue ****************
 *
 * WMLKeyValue:
 * 	key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE) | key2Value=WMLMacro;
 *
 **/

// key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE) | key2Value=WMLMacro
protected class WMLKeyValue_Alternatives extends AlternativesToken {

	public WMLKeyValue_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getWMLKeyValueAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLKeyValue_Key1ValueAssignment_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new WMLKeyValue_Key2ValueAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWMLKeyValueRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE)
protected class WMLKeyValue_Key1ValueAssignment_0 extends AssignmentToken  {
	
	public WMLKeyValue_Key1ValueAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLKeyValueAccess().getKey1ValueAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("key1Value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("key1Value");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueIDTerminalRuleCall_0_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueIDTerminalRuleCall_0_0_0();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueSTRINGTerminalRuleCall_0_0_1(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueSTRINGTerminalRuleCall_0_0_1();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueTSTRINGParserRuleCall_0_0_2(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueTSTRINGParserRuleCall_0_0_2();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueFLOATParserRuleCall_0_0_3(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueFLOATParserRuleCall_0_0_3();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueIINTTerminalRuleCall_0_0_4(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueIINTTerminalRuleCall_0_0_4();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValuePATHParserRuleCall_0_0_5(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValuePATHParserRuleCall_0_0_5();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueDIRECTIONParserRuleCall_0_0_6(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueDIRECTIONParserRuleCall_0_0_6();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValueLISTParserRuleCall_0_0_7(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValueLISTParserRuleCall_0_0_7();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getWMLKeyValueAccess().getKey1ValuePROGRESSIVEParserRuleCall_0_0_8(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getWMLKeyValueAccess().getKey1ValuePROGRESSIVEParserRuleCall_0_0_8();
			return obj;
		}
		return null;
	}

}

// key2Value=WMLMacro
protected class WMLKeyValue_Key2ValueAssignment_1 extends AssignmentToken  {
	
	public WMLKeyValue_Key2ValueAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWMLKeyValueAccess().getKey2ValueAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WMLMacro_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("key2Value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("key2Value");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getWMLMacroRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWMLKeyValueAccess().getKey2ValueWMLMacroParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}


/************ end Rule WMLKeyValue ****************/







}

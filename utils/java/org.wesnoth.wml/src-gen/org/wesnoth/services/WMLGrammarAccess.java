/*
* generated by Xtext
*/

package org.wesnoth.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class WMLGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class WMLRootElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WMLRoot");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cRtagsAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cRtagsWMLTagParserRuleCall_0_0 = (RuleCall)cRtagsAssignment_0.eContents().get(0);
		private final Assignment cRmacrosAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cRmacrosWMLMacroParserRuleCall_1_0 = (RuleCall)cRmacrosAssignment_1.eContents().get(0);
		
		//WMLRoot:
		//	(Rtags+=WMLTag | Rmacros+=WMLMacro)*;
		public ParserRule getRule() { return rule; }

		//(Rtags+=WMLTag | Rmacros+=WMLMacro)*
		public Alternatives getAlternatives() { return cAlternatives; }

		//Rtags+=WMLTag
		public Assignment getRtagsAssignment_0() { return cRtagsAssignment_0; }

		//WMLTag
		public RuleCall getRtagsWMLTagParserRuleCall_0_0() { return cRtagsWMLTagParserRuleCall_0_0; }

		//Rmacros+=WMLMacro
		public Assignment getRmacrosAssignment_1() { return cRmacrosAssignment_1; }

		//WMLMacro
		public RuleCall getRmacrosWMLMacroParserRuleCall_1_0() { return cRmacrosWMLMacroParserRuleCall_1_0; }
	}

	public class WMLMacroElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WMLMacro");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cValueAlternatives_2_0 = (Alternatives)cValueAssignment_2.eContents().get(0);
		private final RuleCall cValueIDTerminalRuleCall_2_0_0 = (RuleCall)cValueAlternatives_2_0.eContents().get(0);
		private final RuleCall cValueSTRINGTerminalRuleCall_2_0_1 = (RuleCall)cValueAlternatives_2_0.eContents().get(1);
		private final Keyword cValue_Keyword_2_0_2 = (Keyword)cValueAlternatives_2_0.eContents().get(2);
		private final Keyword cValueColonKeyword_2_0_3 = (Keyword)cValueAlternatives_2_0.eContents().get(3);
		private final Keyword cValueHyphenMinusKeyword_2_0_4 = (Keyword)cValueAlternatives_2_0.eContents().get(4);
		private final Keyword cValueFullStopKeyword_2_0_5 = (Keyword)cValueAlternatives_2_0.eContents().get(5);
		private final Keyword cValueLeftParenthesisKeyword_2_0_6 = (Keyword)cValueAlternatives_2_0.eContents().get(6);
		private final Keyword cValueRightParenthesisKeyword_2_0_7 = (Keyword)cValueAlternatives_2_0.eContents().get(7);
		private final Keyword cValueEqualsSignKeyword_2_0_8 = (Keyword)cValueAlternatives_2_0.eContents().get(8);
		private final Keyword cValueSolidusKeyword_2_0_9 = (Keyword)cValueAlternatives_2_0.eContents().get(9);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//WMLMacro:
		//	"{" name=ID value+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")* "}";
		public ParserRule getRule() { return rule; }

		//"{" name=ID value+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")* "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//value+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")*
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/"
		public Alternatives getValueAlternatives_2_0() { return cValueAlternatives_2_0; }

		//ID
		public RuleCall getValueIDTerminalRuleCall_2_0_0() { return cValueIDTerminalRuleCall_2_0_0; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_2_0_1() { return cValueSTRINGTerminalRuleCall_2_0_1; }

		//"_"
		public Keyword getValue_Keyword_2_0_2() { return cValue_Keyword_2_0_2; }

		//":"
		public Keyword getValueColonKeyword_2_0_3() { return cValueColonKeyword_2_0_3; }

		//"-"
		public Keyword getValueHyphenMinusKeyword_2_0_4() { return cValueHyphenMinusKeyword_2_0_4; }

		//"."
		public Keyword getValueFullStopKeyword_2_0_5() { return cValueFullStopKeyword_2_0_5; }

		//"("
		public Keyword getValueLeftParenthesisKeyword_2_0_6() { return cValueLeftParenthesisKeyword_2_0_6; }

		//")"
		public Keyword getValueRightParenthesisKeyword_2_0_7() { return cValueRightParenthesisKeyword_2_0_7; }

		//"="
		public Keyword getValueEqualsSignKeyword_2_0_8() { return cValueEqualsSignKeyword_2_0_8; }

		//"/"
		public Keyword getValueSolidusKeyword_2_0_9() { return cValueSolidusKeyword_2_0_9; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class WMLTagElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WMLTag");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cTtagsAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cTtagsWMLTagParserRuleCall_3_0_0 = (RuleCall)cTtagsAssignment_3_0.eContents().get(0);
		private final Assignment cTkeysAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cTkeysWMLKeyParserRuleCall_3_1_0 = (RuleCall)cTkeysAssignment_3_1.eContents().get(0);
		private final Assignment cTmacrosAssignment_3_2 = (Assignment)cAlternatives_3.eContents().get(2);
		private final RuleCall cTmacrosWMLMacroParserRuleCall_3_2_0 = (RuleCall)cTmacrosAssignment_3_2.eContents().get(0);
		private final Assignment cEndAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cEndWMLEndTagParserRuleCall_4_0 = (RuleCall)cEndAssignment_4.eContents().get(0);
		
		//WMLTag:
		//	"[" name=ID "]" (Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)* end=WMLEndTag;
		public ParserRule getRule() { return rule; }

		//"[" name=ID "]" (Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)* end=WMLEndTag
		public Group getGroup() { return cGroup; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }

		//(Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)*
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//Ttags+=WMLTag
		public Assignment getTtagsAssignment_3_0() { return cTtagsAssignment_3_0; }

		//WMLTag
		public RuleCall getTtagsWMLTagParserRuleCall_3_0_0() { return cTtagsWMLTagParserRuleCall_3_0_0; }

		//Tkeys+=WMLKey
		public Assignment getTkeysAssignment_3_1() { return cTkeysAssignment_3_1; }

		//WMLKey
		public RuleCall getTkeysWMLKeyParserRuleCall_3_1_0() { return cTkeysWMLKeyParserRuleCall_3_1_0; }

		//Tmacros+=WMLMacro
		public Assignment getTmacrosAssignment_3_2() { return cTmacrosAssignment_3_2; }

		//WMLMacro
		public RuleCall getTmacrosWMLMacroParserRuleCall_3_2_0() { return cTmacrosWMLMacroParserRuleCall_3_2_0; }

		//end=WMLEndTag
		public Assignment getEndAssignment_4() { return cEndAssignment_4; }

		//WMLEndTag
		public RuleCall getEndWMLEndTagParserRuleCall_4_0() { return cEndWMLEndTagParserRuleCall_4_0; }
	}

	public class WMLEndTagElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WMLEndTag");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketSolidusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTagnameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTagnameIDTerminalRuleCall_1_0 = (RuleCall)cTagnameAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		////WMLStartTag:
		////	'[' name = ID ']'
		////	;
		//WMLEndTag:
		//	"[/" tagname=ID "]";
		public ParserRule getRule() { return rule; }

		//"[/" tagname=ID "]"
		public Group getGroup() { return cGroup; }

		//"[/"
		public Keyword getLeftSquareBracketSolidusKeyword_0() { return cLeftSquareBracketSolidusKeyword_0; }

		//tagname=ID
		public Assignment getTagnameAssignment_1() { return cTagnameAssignment_1; }

		//ID
		public RuleCall getTagnameIDTerminalRuleCall_1_0() { return cTagnameIDTerminalRuleCall_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}

	public class WMLKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WMLKey");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyNameIDTerminalRuleCall_0_0 = (RuleCall)cKeyNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueWMLKeyValueParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//WMLKey:
		//	keyName=ID "=" value=WMLKeyValue;
		public ParserRule getRule() { return rule; }

		//keyName=ID "=" value=WMLKeyValue
		public Group getGroup() { return cGroup; }

		//keyName=ID
		public Assignment getKeyNameAssignment_0() { return cKeyNameAssignment_0; }

		//ID
		public RuleCall getKeyNameIDTerminalRuleCall_0_0() { return cKeyNameIDTerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//value=WMLKeyValue
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//WMLKeyValue
		public RuleCall getValueWMLKeyValueParserRuleCall_2_0() { return cValueWMLKeyValueParserRuleCall_2_0; }
	}

	public class WMLKeyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WMLKeyValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cKey1ValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Alternatives cKey1ValueAlternatives_0_0 = (Alternatives)cKey1ValueAssignment_0.eContents().get(0);
		private final RuleCall cKey1ValueIDTerminalRuleCall_0_0_0 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(0);
		private final RuleCall cKey1ValueSTRINGTerminalRuleCall_0_0_1 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(1);
		private final RuleCall cKey1ValueTSTRINGParserRuleCall_0_0_2 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(2);
		private final RuleCall cKey1ValueFLOATParserRuleCall_0_0_3 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(3);
		private final RuleCall cKey1ValueIINTTerminalRuleCall_0_0_4 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(4);
		private final RuleCall cKey1ValuePATHParserRuleCall_0_0_5 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(5);
		private final RuleCall cKey1ValueDIRECTIONParserRuleCall_0_0_6 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(6);
		private final RuleCall cKey1ValueLISTParserRuleCall_0_0_7 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(7);
		private final RuleCall cKey1ValuePROGRESSIVEParserRuleCall_0_0_8 = (RuleCall)cKey1ValueAlternatives_0_0.eContents().get(8);
		private final Assignment cKey2ValueAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cKey2ValueWMLMacroParserRuleCall_1_0 = (RuleCall)cKey2ValueAssignment_1.eContents().get(0);
		
		//WMLKeyValue:
		//	key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE) | key2Value=WMLMacro;
		public ParserRule getRule() { return rule; }

		//key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE) | key2Value=WMLMacro
		public Alternatives getAlternatives() { return cAlternatives; }

		//key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE)
		public Assignment getKey1ValueAssignment_0() { return cKey1ValueAssignment_0; }

		//ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE
		public Alternatives getKey1ValueAlternatives_0_0() { return cKey1ValueAlternatives_0_0; }

		//ID
		public RuleCall getKey1ValueIDTerminalRuleCall_0_0_0() { return cKey1ValueIDTerminalRuleCall_0_0_0; }

		//STRING
		public RuleCall getKey1ValueSTRINGTerminalRuleCall_0_0_1() { return cKey1ValueSTRINGTerminalRuleCall_0_0_1; }

		//TSTRING
		public RuleCall getKey1ValueTSTRINGParserRuleCall_0_0_2() { return cKey1ValueTSTRINGParserRuleCall_0_0_2; }

		//FLOAT
		public RuleCall getKey1ValueFLOATParserRuleCall_0_0_3() { return cKey1ValueFLOATParserRuleCall_0_0_3; }

		//IINT
		public RuleCall getKey1ValueIINTTerminalRuleCall_0_0_4() { return cKey1ValueIINTTerminalRuleCall_0_0_4; }

		//PATH
		public RuleCall getKey1ValuePATHParserRuleCall_0_0_5() { return cKey1ValuePATHParserRuleCall_0_0_5; }

		//DIRECTION
		public RuleCall getKey1ValueDIRECTIONParserRuleCall_0_0_6() { return cKey1ValueDIRECTIONParserRuleCall_0_0_6; }

		//LIST
		public RuleCall getKey1ValueLISTParserRuleCall_0_0_7() { return cKey1ValueLISTParserRuleCall_0_0_7; }

		//PROGRESSIVE
		public RuleCall getKey1ValuePROGRESSIVEParserRuleCall_0_0_8() { return cKey1ValuePROGRESSIVEParserRuleCall_0_0_8; }

		//key2Value=WMLMacro
		public Assignment getKey2ValueAssignment_1() { return cKey2ValueAssignment_1; }

		//WMLMacro
		public RuleCall getKey2ValueWMLMacroParserRuleCall_1_0() { return cKey2ValueWMLMacroParserRuleCall_1_0; }
	}

	public class FLOATElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FLOAT");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cIINTTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//FLOAT returns ecore::EString hidden():
		//	IINT "." IINT+;
		public ParserRule getRule() { return rule; }

		//IINT "." IINT+
		public Group getGroup() { return cGroup; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_0() { return cIINTTerminalRuleCall_0; }

		//"."
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }

		//IINT+
		public RuleCall getIINTTerminalRuleCall_2() { return cIINTTerminalRuleCall_2; }
	}

	public class TSTRINGElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TSTRING");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cSpaceKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Keyword c_Keyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Keyword cSpaceKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cSTRINGTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//TSTRING returns ecore::EString:
		//	(" "? "_" " "?) STRING;
		public ParserRule getRule() { return rule; }

		//(" "? "_" " "?) STRING
		public Group getGroup() { return cGroup; }

		//" "? "_" " "?
		public Group getGroup_0() { return cGroup_0; }

		//" "?
		public Keyword getSpaceKeyword_0_0() { return cSpaceKeyword_0_0; }

		//"_"
		public Keyword get_Keyword_0_1() { return c_Keyword_0_1; }

		//" "?
		public Keyword getSpaceKeyword_0_2() { return cSpaceKeyword_0_2; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_1() { return cSTRINGTerminalRuleCall_1; }
	}

	public class PATHElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PATH");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cGroup_0.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0_1_0 = (Keyword)cAlternatives_0_1.eContents().get(0);
		private final Keyword cSolidusKeyword_0_1_1 = (Keyword)cAlternatives_0_1.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//PATH returns ecore::EString:
		//	(ID+ ("-" | "/"))* ID+ "." ID+;
		public ParserRule getRule() { return rule; }

		//(ID+ ("-" | "/"))* ID+ "." ID+
		public Group getGroup() { return cGroup; }

		//(ID+ ("-" | "/"))*
		public Group getGroup_0() { return cGroup_0; }

		//ID+
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"-" | "/"
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1_0() { return cHyphenMinusKeyword_0_1_0; }

		//"/"
		public Keyword getSolidusKeyword_0_1_1() { return cSolidusKeyword_0_1_1; }

		//ID+
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//ID+
		public RuleCall getIDTerminalRuleCall_3() { return cIDTerminalRuleCall_3; }
	}

	public class DIRECTIONElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DIRECTION");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cNKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cSKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Keyword cWKeyword_0_2 = (Keyword)cAlternatives_0.eContents().get(2);
		private final Keyword cEKeyword_0_3 = (Keyword)cAlternatives_0.eContents().get(3);
		private final Keyword cSwKeyword_0_4 = (Keyword)cAlternatives_0.eContents().get(4);
		private final Keyword cSeKeyword_0_5 = (Keyword)cAlternatives_0.eContents().get(5);
		private final Keyword cNeKeyword_0_6 = (Keyword)cAlternatives_0.eContents().get(6);
		private final Keyword cNwKeyword_0_7 = (Keyword)cAlternatives_0.eContents().get(7);
		private final Keyword cCommaKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//DIRECTION returns ecore::EString:
		//	(("n" | "s" | "w" | "e" | "sw" | "se" | "ne" | "nw") ","?)+;
		public ParserRule getRule() { return rule; }

		//(("n" | "s" | "w" | "e" | "sw" | "se" | "ne" | "nw") ","?)+
		public Group getGroup() { return cGroup; }

		//"n" | "s" | "w" | "e" | "sw" | "se" | "ne" | "nw"
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"n"
		public Keyword getNKeyword_0_0() { return cNKeyword_0_0; }

		//"s"
		public Keyword getSKeyword_0_1() { return cSKeyword_0_1; }

		//"w"
		public Keyword getWKeyword_0_2() { return cWKeyword_0_2; }

		//"e"
		public Keyword getEKeyword_0_3() { return cEKeyword_0_3; }

		//"sw"
		public Keyword getSwKeyword_0_4() { return cSwKeyword_0_4; }

		//"se"
		public Keyword getSeKeyword_0_5() { return cSeKeyword_0_5; }

		//"ne"
		public Keyword getNeKeyword_0_6() { return cNeKeyword_0_6; }

		//"nw"
		public Keyword getNwKeyword_0_7() { return cNwKeyword_0_7; }

		//","?
		public Keyword getCommaKeyword_1() { return cCommaKeyword_1; }
	}

	public class LISTElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LIST");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//LIST returns ecore::EString:
		//	ID ("," ID)+;
		public ParserRule getRule() { return rule; }

		//ID ("," ID)+
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("," ID)+
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}

	public class PROGRESSIVEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PROGRESSIVE");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cIINTTerminalRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cFLOATParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cTildeKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final RuleCall cIINTTerminalRuleCall_1_1_0 = (RuleCall)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cFLOATParserRuleCall_1_1_1 = (RuleCall)cAlternatives_1_1.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIINTTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final RuleCall cIINTTerminalRuleCall_3_1_0 = (RuleCall)cAlternatives_3_1.eContents().get(0);
		private final RuleCall cFLOATParserRuleCall_3_1_1 = (RuleCall)cAlternatives_3_1.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cTildeKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Alternatives cAlternatives_3_2_1 = (Alternatives)cGroup_3_2.eContents().get(1);
		private final RuleCall cIINTTerminalRuleCall_3_2_1_0 = (RuleCall)cAlternatives_3_2_1.eContents().get(0);
		private final RuleCall cFLOATParserRuleCall_3_2_1_1 = (RuleCall)cAlternatives_3_2_1.eContents().get(1);
		private final Group cGroup_3_3 = (Group)cGroup_3.eContents().get(3);
		private final Keyword cColonKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final RuleCall cIINTTerminalRuleCall_3_3_1 = (RuleCall)cGroup_3_3.eContents().get(1);
		
		//PROGRESSIVE returns ecore::EString:
		//	(IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)? ("," (IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)?)+;
		public ParserRule getRule() { return rule; }

		//(IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)? ("," (IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)?)+
		public Group getGroup() { return cGroup; }

		//IINT | FLOAT
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_0_0() { return cIINTTerminalRuleCall_0_0; }

		//FLOAT
		public RuleCall getFLOATParserRuleCall_0_1() { return cFLOATParserRuleCall_0_1; }

		//("~" (IINT | FLOAT))?
		public Group getGroup_1() { return cGroup_1; }

		//"~"
		public Keyword getTildeKeyword_1_0() { return cTildeKeyword_1_0; }

		//IINT | FLOAT
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_1_1_0() { return cIINTTerminalRuleCall_1_1_0; }

		//FLOAT
		public RuleCall getFLOATParserRuleCall_1_1_1() { return cFLOATParserRuleCall_1_1_1; }

		//(":" IINT)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_2_1() { return cIINTTerminalRuleCall_2_1; }

		//("," (IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)?)+
		public Group getGroup_3() { return cGroup_3; }

		//","
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//IINT | FLOAT
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_3_1_0() { return cIINTTerminalRuleCall_3_1_0; }

		//FLOAT
		public RuleCall getFLOATParserRuleCall_3_1_1() { return cFLOATParserRuleCall_3_1_1; }

		//("~" (IINT | FLOAT))?
		public Group getGroup_3_2() { return cGroup_3_2; }

		//"~"
		public Keyword getTildeKeyword_3_2_0() { return cTildeKeyword_3_2_0; }

		//IINT | FLOAT
		public Alternatives getAlternatives_3_2_1() { return cAlternatives_3_2_1; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_3_2_1_0() { return cIINTTerminalRuleCall_3_2_1_0; }

		//FLOAT
		public RuleCall getFLOATParserRuleCall_3_2_1_1() { return cFLOATParserRuleCall_3_2_1_1; }

		//(":" IINT)?
		public Group getGroup_3_3() { return cGroup_3_3; }

		//":"
		public Keyword getColonKeyword_3_3_0() { return cColonKeyword_3_3_0; }

		//IINT
		public RuleCall getIINTTerminalRuleCall_3_3_1() { return cIINTTerminalRuleCall_3_3_1; }
	}
	
	
	private WMLRootElements pWMLRoot;
	private WMLMacroElements pWMLMacro;
	private WMLTagElements pWMLTag;
	private WMLEndTagElements pWMLEndTag;
	private WMLKeyElements pWMLKey;
	private WMLKeyValueElements pWMLKeyValue;
	private FLOATElements pFLOAT;
	private TSTRINGElements pTSTRING;
	private PATHElements pPATH;
	private DIRECTIONElements pDIRECTION;
	private LISTElements pLIST;
	private PROGRESSIVEElements pPROGRESSIVE;
	private TerminalRule tSL_COMMENT;
	private TerminalRule tWS;
	private TerminalRule tID;
	private TerminalRule tIINT;
	private TerminalRule tSTRING;
	
	private final GrammarProvider grammarProvider;

	@Inject
	public WMLGrammarAccess(GrammarProvider grammarProvider) {
		this.grammarProvider = grammarProvider;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	
	//WMLRoot:
	//	(Rtags+=WMLTag | Rmacros+=WMLMacro)*;
	public WMLRootElements getWMLRootAccess() {
		return (pWMLRoot != null) ? pWMLRoot : (pWMLRoot = new WMLRootElements());
	}
	
	public ParserRule getWMLRootRule() {
		return getWMLRootAccess().getRule();
	}

	//WMLMacro:
	//	"{" name=ID value+=(ID | STRING | "_" | ":" | "-" | "." | "(" | ")" | "=" | "/")* "}";
	public WMLMacroElements getWMLMacroAccess() {
		return (pWMLMacro != null) ? pWMLMacro : (pWMLMacro = new WMLMacroElements());
	}
	
	public ParserRule getWMLMacroRule() {
		return getWMLMacroAccess().getRule();
	}

	//WMLTag:
	//	"[" name=ID "]" (Ttags+=WMLTag | Tkeys+=WMLKey | Tmacros+=WMLMacro)* end=WMLEndTag;
	public WMLTagElements getWMLTagAccess() {
		return (pWMLTag != null) ? pWMLTag : (pWMLTag = new WMLTagElements());
	}
	
	public ParserRule getWMLTagRule() {
		return getWMLTagAccess().getRule();
	}

	////WMLStartTag:
	////	'[' name = ID ']'
	////	;
	//WMLEndTag:
	//	"[/" tagname=ID "]";
	public WMLEndTagElements getWMLEndTagAccess() {
		return (pWMLEndTag != null) ? pWMLEndTag : (pWMLEndTag = new WMLEndTagElements());
	}
	
	public ParserRule getWMLEndTagRule() {
		return getWMLEndTagAccess().getRule();
	}

	//WMLKey:
	//	keyName=ID "=" value=WMLKeyValue;
	public WMLKeyElements getWMLKeyAccess() {
		return (pWMLKey != null) ? pWMLKey : (pWMLKey = new WMLKeyElements());
	}
	
	public ParserRule getWMLKeyRule() {
		return getWMLKeyAccess().getRule();
	}

	//WMLKeyValue:
	//	key1Value=(ID | STRING | TSTRING | FLOAT | IINT | PATH | DIRECTION | LIST | PROGRESSIVE) | key2Value=WMLMacro;
	public WMLKeyValueElements getWMLKeyValueAccess() {
		return (pWMLKeyValue != null) ? pWMLKeyValue : (pWMLKeyValue = new WMLKeyValueElements());
	}
	
	public ParserRule getWMLKeyValueRule() {
		return getWMLKeyValueAccess().getRule();
	}

	//FLOAT returns ecore::EString hidden():
	//	IINT "." IINT+;
	public FLOATElements getFLOATAccess() {
		return (pFLOAT != null) ? pFLOAT : (pFLOAT = new FLOATElements());
	}
	
	public ParserRule getFLOATRule() {
		return getFLOATAccess().getRule();
	}

	//TSTRING returns ecore::EString:
	//	(" "? "_" " "?) STRING;
	public TSTRINGElements getTSTRINGAccess() {
		return (pTSTRING != null) ? pTSTRING : (pTSTRING = new TSTRINGElements());
	}
	
	public ParserRule getTSTRINGRule() {
		return getTSTRINGAccess().getRule();
	}

	//PATH returns ecore::EString:
	//	(ID+ ("-" | "/"))* ID+ "." ID+;
	public PATHElements getPATHAccess() {
		return (pPATH != null) ? pPATH : (pPATH = new PATHElements());
	}
	
	public ParserRule getPATHRule() {
		return getPATHAccess().getRule();
	}

	//DIRECTION returns ecore::EString:
	//	(("n" | "s" | "w" | "e" | "sw" | "se" | "ne" | "nw") ","?)+;
	public DIRECTIONElements getDIRECTIONAccess() {
		return (pDIRECTION != null) ? pDIRECTION : (pDIRECTION = new DIRECTIONElements());
	}
	
	public ParserRule getDIRECTIONRule() {
		return getDIRECTIONAccess().getRule();
	}

	//LIST returns ecore::EString:
	//	ID ("," ID)+;
	public LISTElements getLISTAccess() {
		return (pLIST != null) ? pLIST : (pLIST = new LISTElements());
	}
	
	public ParserRule getLISTRule() {
		return getLISTAccess().getRule();
	}

	//PROGRESSIVE returns ecore::EString:
	//	(IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)? ("," (IINT | FLOAT) ("~" (IINT | FLOAT))? (":" IINT)?)+;
	public PROGRESSIVEElements getPROGRESSIVEAccess() {
		return (pPROGRESSIVE != null) ? pPROGRESSIVE : (pPROGRESSIVE = new PROGRESSIVEElements());
	}
	
	public ParserRule getPROGRESSIVERule() {
		return getPROGRESSIVEAccess().getRule();
	}

	//terminal SL_COMMENT:
	//	"#" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return (tSL_COMMENT != null) ? tSL_COMMENT : (tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	////terminal MACRO		: '{'->'}';
	////terminal STRINT		: ('a'..'z'|'A'..'Z'|'_'|'.'|'0'..'9')+;
	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return (tWS != null) ? tWS : (tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	////terminal ID  		: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|' '|'_'|'0'..'9')*;
	//terminal ID:
	//	("a".."z" | "A".."Z" | "0".."9") ("a".."z" | "A".."Z" | "_" | " " | "0".."9")*;
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal IINT:
	//	("-" | "+")? "0".."9"+;
	public TerminalRule getIINTRule() {
		return (tIINT != null) ? tIINT : (tIINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "IINT"));
	} 

	////terminal SSTRING	: ( '\\' ('b'|'t'|'n'|'f'|'r'|'"'|"'"|'\\') | !('\\'|'"') )*;
	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return (tSTRING != null) ? tSTRING : (tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 
}

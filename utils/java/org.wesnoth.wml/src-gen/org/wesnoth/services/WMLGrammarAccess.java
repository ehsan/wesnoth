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
	
	
	public class RootElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Root");
		private final UnorderedGroup cUnorderedGroup = (UnorderedGroup)rule.eContents().get(1);
		private final Assignment cTextdomainsAssignment_0 = (Assignment)cUnorderedGroup.eContents().get(0);
		private final RuleCall cTextdomainsTextDomainParserRuleCall_0_0 = (RuleCall)cTextdomainsAssignment_0.eContents().get(0);
		private final Assignment cPreprocAssignment_1 = (Assignment)cUnorderedGroup.eContents().get(1);
		private final RuleCall cPreprocPreprocessorParserRuleCall_1_0 = (RuleCall)cPreprocAssignment_1.eContents().get(0);
		private final Assignment cRootsAssignment_2 = (Assignment)cUnorderedGroup.eContents().get(2);
		private final RuleCall cRootsRootTypeParserRuleCall_2_0 = (RuleCall)cRootsAssignment_2.eContents().get(0);
		
		//Root:
		//	textdomains+=TextDomain* & preproc+=Preprocessor* & roots+=RootType*;
		public ParserRule getRule() { return rule; }

		//textdomains+=TextDomain* & preproc+=Preprocessor* & roots+=RootType*
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//textdomains+=TextDomain*
		public Assignment getTextdomainsAssignment_0() { return cTextdomainsAssignment_0; }

		//TextDomain
		public RuleCall getTextdomainsTextDomainParserRuleCall_0_0() { return cTextdomainsTextDomainParserRuleCall_0_0; }

		//preproc+=Preprocessor*
		public Assignment getPreprocAssignment_1() { return cPreprocAssignment_1; }

		//Preprocessor
		public RuleCall getPreprocPreprocessorParserRuleCall_1_0() { return cPreprocPreprocessorParserRuleCall_1_0; }

		//roots+=RootType*
		public Assignment getRootsAssignment_2() { return cRootsAssignment_2; }

		//RootType
		public RuleCall getRootsRootTypeParserRuleCall_2_0() { return cRootsRootTypeParserRuleCall_2_0; }
	}

	public class TextDomainElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TextDomain");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTextdomainKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cDomainNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDomainNameIDTerminalRuleCall_1_0 = (RuleCall)cDomainNameAssignment_1.eContents().get(0);
		
		//TextDomain:
		//	"#textdomain " DomainName=ID;
		public ParserRule getRule() { return rule; }

		//"#textdomain " DomainName=ID
		public Group getGroup() { return cGroup; }

		//"#textdomain "
		public Keyword getTextdomainKeyword_0() { return cTextdomainKeyword_0; }

		//DomainName=ID
		public Assignment getDomainNameAssignment_1() { return cDomainNameAssignment_1; }

		//ID
		public RuleCall getDomainNameIDTerminalRuleCall_1_0() { return cDomainNameIDTerminalRuleCall_1_0; }
	}

	public class PreprocessorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Preprocessor");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cMacroParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPathIncludeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Preprocessor:
		//	Macro | PathInclude;
		public ParserRule getRule() { return rule; }

		//Macro | PathInclude
		public Alternatives getAlternatives() { return cAlternatives; }

		//Macro
		public RuleCall getMacroParserRuleCall_0() { return cMacroParserRuleCall_0; }

		//PathInclude
		public RuleCall getPathIncludeParserRuleCall_1() { return cPathIncludeParserRuleCall_1; }
	}

	public class MacroElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Macro");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMacroNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMacroNameIDTerminalRuleCall_1_0 = (RuleCall)cMacroNameAssignment_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Macro:
		//	"{" macroName=ID "}";
		public ParserRule getRule() { return rule; }

		//"{" macroName=ID "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//macroName=ID
		public Assignment getMacroNameAssignment_1() { return cMacroNameAssignment_1; }

		//ID
		public RuleCall getMacroNameIDTerminalRuleCall_1_0() { return cMacroNameIDTerminalRuleCall_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
	}

	public class PathIncludeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PathInclude");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPathAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cPathAlternatives_1_0 = (Alternatives)cPathAssignment_1.eContents().get(0);
		private final RuleCall cPathHOMEPATHParserRuleCall_1_0_0 = (RuleCall)cPathAlternatives_1_0.eContents().get(0);
		private final RuleCall cPathPATHTerminalRuleCall_1_0_1 = (RuleCall)cPathAlternatives_1_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//PathInclude:
		//	"{" path=(HOMEPATH | PATH) "}";
		public ParserRule getRule() { return rule; }

		//"{" path=(HOMEPATH | PATH) "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//path=(HOMEPATH | PATH)
		public Assignment getPathAssignment_1() { return cPathAssignment_1; }

		//HOMEPATH | PATH
		public Alternatives getPathAlternatives_1_0() { return cPathAlternatives_1_0; }

		//HOMEPATH
		public RuleCall getPathHOMEPATHParserRuleCall_1_0_0() { return cPathHOMEPATHParserRuleCall_1_0_0; }

		//PATH
		public RuleCall getPathPATHTerminalRuleCall_1_0_1() { return cPathPATHTerminalRuleCall_1_0_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
	}

	public class RootTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RootType");
		private final UnorderedGroup cUnorderedGroup = (UnorderedGroup)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cUnorderedGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cStartTagAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cStartTagRootTagParserRuleCall_0_1_0 = (RuleCall)cStartTagAssignment_0_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cSubTypesAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cSubTypesRootTypeParserRuleCall_0_3_0 = (RuleCall)cSubTypesAssignment_0_3.eContents().get(0);
		private final Assignment cAtAssignment_1 = (Assignment)cUnorderedGroup.eContents().get(1);
		private final RuleCall cAtAttributesParserRuleCall_1_0 = (RuleCall)cAtAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cUnorderedGroup.eContents().get(2);
		private final Assignment cOkpreprocAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOkpreprocPreprocessorParserRuleCall_2_0_0 = (RuleCall)cOkpreprocAssignment_2_0.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cSolidusKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Assignment cEndTagAssignment_2_3 = (Assignment)cGroup_2.eContents().get(3);
		private final RuleCall cEndTagRootTagParserRuleCall_2_3_0 = (RuleCall)cEndTagAssignment_2_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_4 = (Keyword)cGroup_2.eContents().get(4);
		
		//RootType:
		//	"[" startTag=RootTag "]" subTypes+=RootType* & at+=Attributes* & okpreproc+=Preprocessor* "[" "/" endTag=RootTag "]";
		public ParserRule getRule() { return rule; }

		//"[" startTag=RootTag "]" subTypes+=RootType* & at+=Attributes* & okpreproc+=Preprocessor* "[" "/" endTag=RootTag "]"
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//"[" startTag=RootTag "]" subTypes+=RootType*
		public Group getGroup_0() { return cGroup_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0_0() { return cLeftSquareBracketKeyword_0_0; }

		//startTag=RootTag
		public Assignment getStartTagAssignment_0_1() { return cStartTagAssignment_0_1; }

		//RootTag
		public RuleCall getStartTagRootTagParserRuleCall_0_1_0() { return cStartTagRootTagParserRuleCall_0_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_0_2() { return cRightSquareBracketKeyword_0_2; }

		//subTypes+=RootType*
		public Assignment getSubTypesAssignment_0_3() { return cSubTypesAssignment_0_3; }

		//RootType
		public RuleCall getSubTypesRootTypeParserRuleCall_0_3_0() { return cSubTypesRootTypeParserRuleCall_0_3_0; }

		//at+=Attributes*
		public Assignment getAtAssignment_1() { return cAtAssignment_1; }

		//Attributes
		public RuleCall getAtAttributesParserRuleCall_1_0() { return cAtAttributesParserRuleCall_1_0; }

		//okpreproc+=Preprocessor* "[" "/" endTag=RootTag "]"
		public Group getGroup_2() { return cGroup_2; }

		//okpreproc+=Preprocessor*
		public Assignment getOkpreprocAssignment_2_0() { return cOkpreprocAssignment_2_0; }

		//Preprocessor
		public RuleCall getOkpreprocPreprocessorParserRuleCall_2_0_0() { return cOkpreprocPreprocessorParserRuleCall_2_0_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2_1() { return cLeftSquareBracketKeyword_2_1; }

		//"/"
		public Keyword getSolidusKeyword_2_2() { return cSolidusKeyword_2_2; }

		//endTag=RootTag
		public Assignment getEndTagAssignment_2_3() { return cEndTagAssignment_2_3; }

		//RootTag
		public RuleCall getEndTagRootTagParserRuleCall_2_3_0() { return cEndTagRootTagParserRuleCall_2_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_4() { return cRightSquareBracketKeyword_2_4; }
	}

	public class RootTagElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RootTag");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSimpleTagParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAddedTagParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//RootTag:
		//	SimpleTag | AddedTag;
		public ParserRule getRule() { return rule; }

		//SimpleTag | AddedTag
		public Alternatives getAlternatives() { return cAlternatives; }

		//SimpleTag
		public RuleCall getSimpleTagParserRuleCall_0() { return cSimpleTagParserRuleCall_0; }

		//AddedTag
		public RuleCall getAddedTagParserRuleCall_1() { return cAddedTagParserRuleCall_1; }
	}

	public class SimpleTagElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleTag");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cEndTagAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cEndTagSolidusKeyword_0_0 = (Keyword)cEndTagAssignment_0.eContents().get(0);
		private final Assignment cTagNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTagNameRootTagsListParserRuleCall_1_0 = (RuleCall)cTagNameAssignment_1.eContents().get(0);
		
		//SimpleTag:
		//	endTag?="/"? tagName=RootTagsList;
		public ParserRule getRule() { return rule; }

		//endTag?="/"? tagName=RootTagsList
		public Group getGroup() { return cGroup; }

		//endTag?="/"?
		public Assignment getEndTagAssignment_0() { return cEndTagAssignment_0; }

		//"/"
		public Keyword getEndTagSolidusKeyword_0_0() { return cEndTagSolidusKeyword_0_0; }

		//tagName=RootTagsList
		public Assignment getTagNameAssignment_1() { return cTagNameAssignment_1; }

		//RootTagsList
		public RuleCall getTagNameRootTagsListParserRuleCall_1_0() { return cTagNameRootTagsListParserRuleCall_1_0; }
	}

	public class AddedTagElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AddedTag");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTagNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTagNameRootTagsListParserRuleCall_1_0 = (RuleCall)cTagNameAssignment_1.eContents().get(0);
		
		//AddedTag:
		//	"+" tagName=RootTagsList;
		public ParserRule getRule() { return rule; }

		//"+" tagName=RootTagsList
		public Group getGroup() { return cGroup; }

		//"+"
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }

		//tagName=RootTagsList
		public Assignment getTagNameAssignment_1() { return cTagNameAssignment_1; }

		//RootTagsList
		public RuleCall getTagNameRootTagsListParserRuleCall_1_0() { return cTagNameRootTagsListParserRuleCall_1_0; }
	}

	public class RootTagsListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RootTagsList");
		private final RuleCall cIDTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		////'about'  | 'binary_path' | 'campaign' | 'textdomain' | 'units';
		//RootTagsList returns ecore::EString:
		//	ID;
		public ParserRule getRule() { return rule; }

		//ID
		public RuleCall getIDTerminalRuleCall() { return cIDTerminalRuleCall; }
	}

	public class AttributesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Attributes");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAttrNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAttrNameIDTerminalRuleCall_0_0 = (RuleCall)cAttrNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cAttrValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cAttrValueAlternatives_2_0 = (Alternatives)cAttrValueAssignment_2.eContents().get(0);
		private final RuleCall cAttrValueIDTerminalRuleCall_2_0_0 = (RuleCall)cAttrValueAlternatives_2_0.eContents().get(0);
		private final RuleCall cAttrValueIDLISTTerminalRuleCall_2_0_1 = (RuleCall)cAttrValueAlternatives_2_0.eContents().get(1);
		private final RuleCall cAttrValueTSTRINGParserRuleCall_2_0_2 = (RuleCall)cAttrValueAlternatives_2_0.eContents().get(2);
		private final RuleCall cAttrValueSTRINGTerminalRuleCall_2_0_3 = (RuleCall)cAttrValueAlternatives_2_0.eContents().get(3);
		private final RuleCall cAttrValuePATHTerminalRuleCall_2_0_4 = (RuleCall)cAttrValueAlternatives_2_0.eContents().get(4);
		
		//Attributes:
		//	attrName=ID "=" attrValue=(ID | IDLIST | TSTRING | STRING | PATH);
		public ParserRule getRule() { return rule; }

		//attrName=ID "=" attrValue=(ID | IDLIST | TSTRING | STRING | PATH)
		public Group getGroup() { return cGroup; }

		//attrName=ID
		public Assignment getAttrNameAssignment_0() { return cAttrNameAssignment_0; }

		//ID
		public RuleCall getAttrNameIDTerminalRuleCall_0_0() { return cAttrNameIDTerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//attrValue=(ID | IDLIST | TSTRING | STRING | PATH)
		public Assignment getAttrValueAssignment_2() { return cAttrValueAssignment_2; }

		//ID | IDLIST | TSTRING | STRING | PATH
		public Alternatives getAttrValueAlternatives_2_0() { return cAttrValueAlternatives_2_0; }

		//ID
		public RuleCall getAttrValueIDTerminalRuleCall_2_0_0() { return cAttrValueIDTerminalRuleCall_2_0_0; }

		//IDLIST
		public RuleCall getAttrValueIDLISTTerminalRuleCall_2_0_1() { return cAttrValueIDLISTTerminalRuleCall_2_0_1; }

		//TSTRING
		public RuleCall getAttrValueTSTRINGParserRuleCall_2_0_2() { return cAttrValueTSTRINGParserRuleCall_2_0_2; }

		//STRING
		public RuleCall getAttrValueSTRINGTerminalRuleCall_2_0_3() { return cAttrValueSTRINGTerminalRuleCall_2_0_3; }

		//PATH
		public RuleCall getAttrValuePATHTerminalRuleCall_2_0_4() { return cAttrValuePATHTerminalRuleCall_2_0_4; }
	}

	public class TSTRINGElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TSTRING");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c_Keyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cSTRINGTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//// translatable string
		//TSTRING returns ecore::EString:
		//	"_" STRING;
		public ParserRule getRule() { return rule; }

		//"_" STRING
		public Group getGroup() { return cGroup; }

		//"_"
		public Keyword get_Keyword_0() { return c_Keyword_0; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_1() { return cSTRINGTerminalRuleCall_1; }
	}

	public class HOMEPATHElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "HOMEPATH");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTildeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cPATHTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//HOMEPATH returns ecore::EString:
		//	"~" PATH;
		public ParserRule getRule() { return rule; }

		//"~" PATH
		public Group getGroup() { return cGroup; }

		//"~"
		public Keyword getTildeKeyword_0() { return cTildeKeyword_0; }

		//PATH
		public RuleCall getPATHTerminalRuleCall_1() { return cPATHTerminalRuleCall_1; }
	}
	
	
	private RootElements pRoot;
	private TextDomainElements pTextDomain;
	private PreprocessorElements pPreprocessor;
	private MacroElements pMacro;
	private PathIncludeElements pPathInclude;
	private RootTypeElements pRootType;
	private RootTagElements pRootTag;
	private SimpleTagElements pSimpleTag;
	private AddedTagElements pAddedTag;
	private RootTagsListElements pRootTagsList;
	private AttributesElements pAttributes;
	private TSTRINGElements pTSTRING;
	private HOMEPATHElements pHOMEPATH;
	private TerminalRule tSL_COMMENT;
	private TerminalRule tWS;
	private TerminalRule tID;
	private TerminalRule tIDLIST;
	private TerminalRule tSTRING;
	private TerminalRule tANY_OTHER;
	private TerminalRule tPATH;
	
	private final GrammarProvider grammarProvider;

	@Inject
	public WMLGrammarAccess(GrammarProvider grammarProvider) {
		this.grammarProvider = grammarProvider;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	
	//Root:
	//	textdomains+=TextDomain* & preproc+=Preprocessor* & roots+=RootType*;
	public RootElements getRootAccess() {
		return (pRoot != null) ? pRoot : (pRoot = new RootElements());
	}
	
	public ParserRule getRootRule() {
		return getRootAccess().getRule();
	}

	//TextDomain:
	//	"#textdomain " DomainName=ID;
	public TextDomainElements getTextDomainAccess() {
		return (pTextDomain != null) ? pTextDomain : (pTextDomain = new TextDomainElements());
	}
	
	public ParserRule getTextDomainRule() {
		return getTextDomainAccess().getRule();
	}

	//Preprocessor:
	//	Macro | PathInclude;
	public PreprocessorElements getPreprocessorAccess() {
		return (pPreprocessor != null) ? pPreprocessor : (pPreprocessor = new PreprocessorElements());
	}
	
	public ParserRule getPreprocessorRule() {
		return getPreprocessorAccess().getRule();
	}

	//Macro:
	//	"{" macroName=ID "}";
	public MacroElements getMacroAccess() {
		return (pMacro != null) ? pMacro : (pMacro = new MacroElements());
	}
	
	public ParserRule getMacroRule() {
		return getMacroAccess().getRule();
	}

	//PathInclude:
	//	"{" path=(HOMEPATH | PATH) "}";
	public PathIncludeElements getPathIncludeAccess() {
		return (pPathInclude != null) ? pPathInclude : (pPathInclude = new PathIncludeElements());
	}
	
	public ParserRule getPathIncludeRule() {
		return getPathIncludeAccess().getRule();
	}

	//RootType:
	//	"[" startTag=RootTag "]" subTypes+=RootType* & at+=Attributes* & okpreproc+=Preprocessor* "[" "/" endTag=RootTag "]";
	public RootTypeElements getRootTypeAccess() {
		return (pRootType != null) ? pRootType : (pRootType = new RootTypeElements());
	}
	
	public ParserRule getRootTypeRule() {
		return getRootTypeAccess().getRule();
	}

	//RootTag:
	//	SimpleTag | AddedTag;
	public RootTagElements getRootTagAccess() {
		return (pRootTag != null) ? pRootTag : (pRootTag = new RootTagElements());
	}
	
	public ParserRule getRootTagRule() {
		return getRootTagAccess().getRule();
	}

	//SimpleTag:
	//	endTag?="/"? tagName=RootTagsList;
	public SimpleTagElements getSimpleTagAccess() {
		return (pSimpleTag != null) ? pSimpleTag : (pSimpleTag = new SimpleTagElements());
	}
	
	public ParserRule getSimpleTagRule() {
		return getSimpleTagAccess().getRule();
	}

	//AddedTag:
	//	"+" tagName=RootTagsList;
	public AddedTagElements getAddedTagAccess() {
		return (pAddedTag != null) ? pAddedTag : (pAddedTag = new AddedTagElements());
	}
	
	public ParserRule getAddedTagRule() {
		return getAddedTagAccess().getRule();
	}

	////'about'  | 'binary_path' | 'campaign' | 'textdomain' | 'units';
	//RootTagsList returns ecore::EString:
	//	ID;
	public RootTagsListElements getRootTagsListAccess() {
		return (pRootTagsList != null) ? pRootTagsList : (pRootTagsList = new RootTagsListElements());
	}
	
	public ParserRule getRootTagsListRule() {
		return getRootTagsListAccess().getRule();
	}

	//Attributes:
	//	attrName=ID "=" attrValue=(ID | IDLIST | TSTRING | STRING | PATH);
	public AttributesElements getAttributesAccess() {
		return (pAttributes != null) ? pAttributes : (pAttributes = new AttributesElements());
	}
	
	public ParserRule getAttributesRule() {
		return getAttributesAccess().getRule();
	}

	//// translatable string
	//TSTRING returns ecore::EString:
	//	"_" STRING;
	public TSTRINGElements getTSTRINGAccess() {
		return (pTSTRING != null) ? pTSTRING : (pTSTRING = new TSTRINGElements());
	}
	
	public ParserRule getTSTRINGRule() {
		return getTSTRINGAccess().getRule();
	}

	//HOMEPATH returns ecore::EString:
	//	"~" PATH;
	public HOMEPATHElements getHOMEPATHAccess() {
		return (pHOMEPATH != null) ? pHOMEPATH : (pHOMEPATH = new HOMEPATHElements());
	}
	
	public ParserRule getHOMEPATHRule() {
		return getHOMEPATHAccess().getRule();
	}

	//// ==== TERMINAL RULES ====
	//terminal SL_COMMENT:
	//	"#" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return (tSL_COMMENT != null) ? tSL_COMMENT : (tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return (tWS != null) ? tWS : (tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	//// no multiline comment defined on WML, 
	//// terminal ML_COMMENT: '#' !('\n'|'\r')* ('\r'? '\n')?;
	//terminal ID:
	//	("a".."z" | "A".."Z" | "_" | "-" | "0".."9")+;
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal IDLIST:
	//	(ID ",")* ID;
	public TerminalRule getIDLISTRule() {
		return (tIDLIST != null) ? tIDLIST : (tIDLIST = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "IDLIST"));
	} 

	////terminal INT returns ecore::EInt: ('0'..'9')+;
	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" | "n" |
	//	"f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return (tSTRING != null) ? tSTRING : (tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return (tANY_OTHER != null) ? tANY_OTHER : (tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 

	////terminal WORD_START: ' ' | '=';
	////terminal WORD_END	: '#' | ' ';
	//// line end
	////('"')? 
	////('"')?
	//terminal PATH:
	//	(("a".."z" | "A".."Z" | "_" | "." | "-" | "0".."9")+ "/")* ("a".."z" | "A".."Z" | "_" | "." | "-" | "0".."9")+ "/"?;
	public TerminalRule getPATHRule() {
		return (tPATH != null) ? tPATH : (tPATH = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "PATH"));
	} 
}

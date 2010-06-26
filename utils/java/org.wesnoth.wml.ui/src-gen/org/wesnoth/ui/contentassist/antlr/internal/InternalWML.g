/*
* generated by Xtext
*/
grammar InternalWML;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.wesnoth.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.wesnoth.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.wesnoth.services.WMLGrammarAccess;

}

@parser::members {
 
 	private WMLGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(WMLGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleRoot
entryRuleRoot 
:
{ before(grammarAccess.getRootRule()); }
	 ruleRoot
{ after(grammarAccess.getRootRule()); } 
	 EOF 
;

// Rule Root
ruleRoot
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRootAccess().getGroup()); }
(rule__Root__Group__0)
{ after(grammarAccess.getRootAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTextDomain
entryRuleTextDomain 
:
{ before(grammarAccess.getTextDomainRule()); }
	 ruleTextDomain
{ after(grammarAccess.getTextDomainRule()); } 
	 EOF 
;

// Rule TextDomain
ruleTextDomain
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTextDomainAccess().getGroup()); }
(rule__TextDomain__Group__0)
{ after(grammarAccess.getTextDomainAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePreprocessor
entryRulePreprocessor 
:
{ before(grammarAccess.getPreprocessorRule()); }
	 rulePreprocessor
{ after(grammarAccess.getPreprocessorRule()); } 
	 EOF 
;

// Rule Preprocessor
rulePreprocessor
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPreprocessorAccess().getAlternatives()); }
(rule__Preprocessor__Alternatives)
{ after(grammarAccess.getPreprocessorAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMacro
entryRuleMacro 
:
{ before(grammarAccess.getMacroRule()); }
	 ruleMacro
{ after(grammarAccess.getMacroRule()); } 
	 EOF 
;

// Rule Macro
ruleMacro
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMacroAccess().getGroup()); }
(rule__Macro__Group__0)
{ after(grammarAccess.getMacroAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePathInclude
entryRulePathInclude 
:
{ before(grammarAccess.getPathIncludeRule()); }
	 rulePathInclude
{ after(grammarAccess.getPathIncludeRule()); } 
	 EOF 
;

// Rule PathInclude
rulePathInclude
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPathIncludeAccess().getGroup()); }
(rule__PathInclude__Group__0)
{ after(grammarAccess.getPathIncludeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRootType
entryRuleRootType 
:
{ before(grammarAccess.getRootTypeRule()); }
	 ruleRootType
{ after(grammarAccess.getRootTypeRule()); } 
	 EOF 
;

// Rule RootType
ruleRootType
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRootTypeAccess().getGroup()); }
(rule__RootType__Group__0)
{ after(grammarAccess.getRootTypeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRootTag
entryRuleRootTag 
:
{ before(grammarAccess.getRootTagRule()); }
	 ruleRootTag
{ after(grammarAccess.getRootTagRule()); } 
	 EOF 
;

// Rule RootTag
ruleRootTag
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRootTagAccess().getAlternatives()); }
(rule__RootTag__Alternatives)
{ after(grammarAccess.getRootTagAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSimpleTag
entryRuleSimpleTag 
:
{ before(grammarAccess.getSimpleTagRule()); }
	 ruleSimpleTag
{ after(grammarAccess.getSimpleTagRule()); } 
	 EOF 
;

// Rule SimpleTag
ruleSimpleTag
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSimpleTagAccess().getGroup()); }
(rule__SimpleTag__Group__0)
{ after(grammarAccess.getSimpleTagAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAddedTag
entryRuleAddedTag 
:
{ before(grammarAccess.getAddedTagRule()); }
	 ruleAddedTag
{ after(grammarAccess.getAddedTagRule()); } 
	 EOF 
;

// Rule AddedTag
ruleAddedTag
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAddedTagAccess().getGroup()); }
(rule__AddedTag__Group__0)
{ after(grammarAccess.getAddedTagAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRootTagsList
entryRuleRootTagsList 
:
{ before(grammarAccess.getRootTagsListRule()); }
	 ruleRootTagsList
{ after(grammarAccess.getRootTagsListRule()); } 
	 EOF 
;

// Rule RootTagsList
ruleRootTagsList
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRootTagsListAccess().getIDTerminalRuleCall()); }
	RULE_ID
{ after(grammarAccess.getRootTagsListAccess().getIDTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAttributes
entryRuleAttributes 
:
{ before(grammarAccess.getAttributesRule()); }
	 ruleAttributes
{ after(grammarAccess.getAttributesRule()); } 
	 EOF 
;

// Rule Attributes
ruleAttributes
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAttributesAccess().getGroup()); }
(rule__Attributes__Group__0)
{ after(grammarAccess.getAttributesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTSTRING
entryRuleTSTRING 
:
{ before(grammarAccess.getTSTRINGRule()); }
	 ruleTSTRING
{ after(grammarAccess.getTSTRINGRule()); } 
	 EOF 
;

// Rule TSTRING
ruleTSTRING
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTSTRINGAccess().getGroup()); }
(rule__TSTRING__Group__0)
{ after(grammarAccess.getTSTRINGAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleHOMEPATH
entryRuleHOMEPATH 
:
{ before(grammarAccess.getHOMEPATHRule()); }
	 ruleHOMEPATH
{ after(grammarAccess.getHOMEPATHRule()); } 
	 EOF 
;

// Rule HOMEPATH
ruleHOMEPATH
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getHOMEPATHAccess().getGroup()); }
(rule__HOMEPATH__Group__0)
{ after(grammarAccess.getHOMEPATHAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Preprocessor__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreprocessorAccess().getMacroParserRuleCall_0()); }
	ruleMacro
{ after(grammarAccess.getPreprocessorAccess().getMacroParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getPreprocessorAccess().getPathIncludeParserRuleCall_1()); }
	rulePathInclude
{ after(grammarAccess.getPreprocessorAccess().getPathIncludeParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PathInclude__PathAlternatives_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathIncludeAccess().getPathHOMEPATHParserRuleCall_1_0_0()); }
	ruleHOMEPATH
{ after(grammarAccess.getPathIncludeAccess().getPathHOMEPATHParserRuleCall_1_0_0()); }
)

    |(
{ before(grammarAccess.getPathIncludeAccess().getPathPATHTerminalRuleCall_1_0_1()); }
	RULE_PATH
{ after(grammarAccess.getPathIncludeAccess().getPathPATHTerminalRuleCall_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RootTag__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTagAccess().getSimpleTagParserRuleCall_0()); }
	ruleSimpleTag
{ after(grammarAccess.getRootTagAccess().getSimpleTagParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getRootTagAccess().getAddedTagParserRuleCall_1()); }
	ruleAddedTag
{ after(grammarAccess.getRootTagAccess().getAddedTagParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attributes__AttrValueAlternatives_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributesAccess().getAttrValueTSTRINGParserRuleCall_2_0_0()); }
	ruleTSTRING
{ after(grammarAccess.getAttributesAccess().getAttrValueTSTRINGParserRuleCall_2_0_0()); }
)

    |(
{ before(grammarAccess.getAttributesAccess().getAttrValueSTRINGTerminalRuleCall_2_0_1()); }
	RULE_STRING
{ after(grammarAccess.getAttributesAccess().getAttrValueSTRINGTerminalRuleCall_2_0_1()); }
)

    |(
{ before(grammarAccess.getAttributesAccess().getAttrValuePATHTerminalRuleCall_2_0_2()); }
	RULE_PATH
{ after(grammarAccess.getAttributesAccess().getAttrValuePATHTerminalRuleCall_2_0_2()); }
)

    |(
{ before(grammarAccess.getAttributesAccess().getAttrValueIDTerminalRuleCall_2_0_3()); }
	RULE_ID
{ after(grammarAccess.getAttributesAccess().getAttrValueIDTerminalRuleCall_2_0_3()); }
)

    |(
{ before(grammarAccess.getAttributesAccess().getAttrValueIDLISTTerminalRuleCall_2_0_4()); }
	RULE_IDLIST
{ after(grammarAccess.getAttributesAccess().getAttrValueIDLISTTerminalRuleCall_2_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Root__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Root__Group__0__Impl
	rule__Root__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Root__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootAccess().getTextdomainsAssignment_0()); }
(rule__Root__TextdomainsAssignment_0)*
{ after(grammarAccess.getRootAccess().getTextdomainsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Root__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Root__Group__1__Impl
	rule__Root__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Root__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootAccess().getPreprocAssignment_1()); }
(rule__Root__PreprocAssignment_1)*
{ after(grammarAccess.getRootAccess().getPreprocAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Root__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Root__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Root__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootAccess().getRootsAssignment_2()); }
(rule__Root__RootsAssignment_2)*
{ after(grammarAccess.getRootAccess().getRootsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TextDomain__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TextDomain__Group__0__Impl
	rule__TextDomain__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TextDomain__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTextDomainAccess().getTextdomainKeyword_0()); }

	'#textdomain ' 

{ after(grammarAccess.getTextDomainAccess().getTextdomainKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TextDomain__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TextDomain__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TextDomain__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTextDomainAccess().getDomainNameAssignment_1()); }
(rule__TextDomain__DomainNameAssignment_1)
{ after(grammarAccess.getTextDomainAccess().getDomainNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Macro__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Macro__Group__0__Impl
	rule__Macro__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Macro__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMacroAccess().getLeftCurlyBracketKeyword_0()); }

	'{' 

{ after(grammarAccess.getMacroAccess().getLeftCurlyBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Macro__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Macro__Group__1__Impl
	rule__Macro__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Macro__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getMacroAccess().getMacroContentAssignment_1()); }
(rule__Macro__MacroContentAssignment_1)
{ after(grammarAccess.getMacroAccess().getMacroContentAssignment_1()); }
)
(
{ before(grammarAccess.getMacroAccess().getMacroContentAssignment_1()); }
(rule__Macro__MacroContentAssignment_1)*
{ after(grammarAccess.getMacroAccess().getMacroContentAssignment_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Macro__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Macro__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Macro__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMacroAccess().getRightCurlyBracketKeyword_2()); }

	'}' 

{ after(grammarAccess.getMacroAccess().getRightCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PathInclude__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathInclude__Group__0__Impl
	rule__PathInclude__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PathInclude__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathIncludeAccess().getLeftCurlyBracketKeyword_0()); }

	'{' 

{ after(grammarAccess.getPathIncludeAccess().getLeftCurlyBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PathInclude__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathInclude__Group__1__Impl
	rule__PathInclude__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PathInclude__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathIncludeAccess().getPathAssignment_1()); }
(rule__PathInclude__PathAssignment_1)
{ after(grammarAccess.getPathIncludeAccess().getPathAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PathInclude__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathInclude__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PathInclude__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathIncludeAccess().getRightCurlyBracketKeyword_2()); }

	'}' 

{ after(grammarAccess.getPathIncludeAccess().getRightCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__RootType__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__0__Impl
	rule__RootType__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getLeftSquareBracketKeyword_0()); }

	'[' 

{ after(grammarAccess.getRootTypeAccess().getLeftSquareBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__1__Impl
	rule__RootType__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getStartTagAssignment_1()); }
(rule__RootType__StartTagAssignment_1)
{ after(grammarAccess.getRootTypeAccess().getStartTagAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__2__Impl
	rule__RootType__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getRightSquareBracketKeyword_2()); }

	']' 

{ after(grammarAccess.getRootTypeAccess().getRightSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__3__Impl
	rule__RootType__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getSubTypesAssignment_3()); }
(rule__RootType__SubTypesAssignment_3)*
{ after(grammarAccess.getRootTypeAccess().getSubTypesAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__4__Impl
	rule__RootType__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getAtAssignment_4()); }
(rule__RootType__AtAssignment_4)*
{ after(grammarAccess.getRootTypeAccess().getAtAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__5__Impl
	rule__RootType__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getOkpreprocAssignment_5()); }
(rule__RootType__OkpreprocAssignment_5)*
{ after(grammarAccess.getRootTypeAccess().getOkpreprocAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__6__Impl
	rule__RootType__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getLeftSquareBracketKeyword_6()); }

	'[' 

{ after(grammarAccess.getRootTypeAccess().getLeftSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__7__Impl
	rule__RootType__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getSolidusKeyword_7()); }

	'/' 

{ after(grammarAccess.getRootTypeAccess().getSolidusKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__8__Impl
	rule__RootType__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getEndTagAssignment_8()); }
(rule__RootType__EndTagAssignment_8)
{ after(grammarAccess.getRootTypeAccess().getEndTagAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RootType__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RootType__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getRightSquareBracketKeyword_9()); }

	']' 

{ after(grammarAccess.getRootTypeAccess().getRightSquareBracketKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__SimpleTag__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SimpleTag__Group__0__Impl
	rule__SimpleTag__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleTag__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleTagAccess().getEndTagAssignment_0()); }
(rule__SimpleTag__EndTagAssignment_0)?
{ after(grammarAccess.getSimpleTagAccess().getEndTagAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleTag__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SimpleTag__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleTag__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleTagAccess().getTagNameAssignment_1()); }
(rule__SimpleTag__TagNameAssignment_1)
{ after(grammarAccess.getSimpleTagAccess().getTagNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AddedTag__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AddedTag__Group__0__Impl
	rule__AddedTag__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AddedTag__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAddedTagAccess().getPlusSignKeyword_0()); }

	'+' 

{ after(grammarAccess.getAddedTagAccess().getPlusSignKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AddedTag__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AddedTag__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AddedTag__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAddedTagAccess().getTagNameAssignment_1()); }
(rule__AddedTag__TagNameAssignment_1)
{ after(grammarAccess.getAddedTagAccess().getTagNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Attributes__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attributes__Group__0__Impl
	rule__Attributes__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Attributes__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributesAccess().getAttrNameAssignment_0()); }
(rule__Attributes__AttrNameAssignment_0)
{ after(grammarAccess.getAttributesAccess().getAttrNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Attributes__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attributes__Group__1__Impl
	rule__Attributes__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Attributes__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributesAccess().getEqualsSignKeyword_1()); }

	'=' 

{ after(grammarAccess.getAttributesAccess().getEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Attributes__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attributes__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Attributes__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributesAccess().getAttrValueAssignment_2()); }
(rule__Attributes__AttrValueAssignment_2)
{ after(grammarAccess.getAttributesAccess().getAttrValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TSTRING__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TSTRING__Group__0__Impl
	rule__TSTRING__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TSTRING__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTSTRINGAccess().get_Keyword_0()); }

	'_' 

{ after(grammarAccess.getTSTRINGAccess().get_Keyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TSTRING__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TSTRING__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TSTRING__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTSTRINGAccess().getSTRINGTerminalRuleCall_1()); }
	RULE_STRING
{ after(grammarAccess.getTSTRINGAccess().getSTRINGTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__HOMEPATH__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HOMEPATH__Group__0__Impl
	rule__HOMEPATH__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__HOMEPATH__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHOMEPATHAccess().getTildeKeyword_0()); }

	'~' 

{ after(grammarAccess.getHOMEPATHAccess().getTildeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HOMEPATH__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HOMEPATH__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__HOMEPATH__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHOMEPATHAccess().getPATHTerminalRuleCall_1()); }
	RULE_PATH
{ after(grammarAccess.getHOMEPATHAccess().getPATHTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__Root__TextdomainsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootAccess().getTextdomainsTextDomainParserRuleCall_0_0()); }
	ruleTextDomain{ after(grammarAccess.getRootAccess().getTextdomainsTextDomainParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Root__PreprocAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootAccess().getPreprocPreprocessorParserRuleCall_1_0()); }
	rulePreprocessor{ after(grammarAccess.getRootAccess().getPreprocPreprocessorParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Root__RootsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootAccess().getRootsRootTypeParserRuleCall_2_0()); }
	ruleRootType{ after(grammarAccess.getRootAccess().getRootsRootTypeParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TextDomain__DomainNameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTextDomainAccess().getDomainNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getTextDomainAccess().getDomainNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Macro__MacroContentAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMacroAccess().getMacroContentIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getMacroAccess().getMacroContentIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PathInclude__PathAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathIncludeAccess().getPathAlternatives_1_0()); }
(rule__PathInclude__PathAlternatives_1_0)
{ after(grammarAccess.getPathIncludeAccess().getPathAlternatives_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__StartTagAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getStartTagRootTagParserRuleCall_1_0()); }
	ruleRootTag{ after(grammarAccess.getRootTypeAccess().getStartTagRootTagParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__SubTypesAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getSubTypesRootTypeParserRuleCall_3_0()); }
	ruleRootType{ after(grammarAccess.getRootTypeAccess().getSubTypesRootTypeParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__AtAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getAtAttributesParserRuleCall_4_0()); }
	ruleAttributes{ after(grammarAccess.getRootTypeAccess().getAtAttributesParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__OkpreprocAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getOkpreprocPreprocessorParserRuleCall_5_0()); }
	rulePreprocessor{ after(grammarAccess.getRootTypeAccess().getOkpreprocPreprocessorParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RootType__EndTagAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRootTypeAccess().getEndTagRootTagParserRuleCall_8_0()); }
	ruleRootTag{ after(grammarAccess.getRootTypeAccess().getEndTagRootTagParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleTag__EndTagAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleTagAccess().getEndTagSolidusKeyword_0_0()); }
(
{ before(grammarAccess.getSimpleTagAccess().getEndTagSolidusKeyword_0_0()); }

	'/' 

{ after(grammarAccess.getSimpleTagAccess().getEndTagSolidusKeyword_0_0()); }
)

{ after(grammarAccess.getSimpleTagAccess().getEndTagSolidusKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleTag__TagNameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleTagAccess().getTagNameRootTagsListParserRuleCall_1_0()); }
	ruleRootTagsList{ after(grammarAccess.getSimpleTagAccess().getTagNameRootTagsListParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AddedTag__TagNameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAddedTagAccess().getTagNameRootTagsListParserRuleCall_1_0()); }
	ruleRootTagsList{ after(grammarAccess.getAddedTagAccess().getTagNameRootTagsListParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attributes__AttrNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributesAccess().getAttrNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getAttributesAccess().getAttrNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attributes__AttrValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributesAccess().getAttrValueAlternatives_2_0()); }
(rule__Attributes__AttrValueAlternatives_2_0)
{ after(grammarAccess.getAttributesAccess().getAttrValueAlternatives_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_SL_COMMENT : '#' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ID : ('a'..'z'|'A'..'Z'|'_'|'-'|' '|'0'..'9')+;

RULE_IDLIST : (RULE_ID ',')* RULE_ID;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ANY_OTHER : .;

RULE_PATH : (('a'..'z'|'A'..'Z'|'_'|'.'|'-'|'0'..'9')+ '/')* ('a'..'z'|'A'..'Z'|'_'|'.'|'-'|'0'..'9')+ '/'?;



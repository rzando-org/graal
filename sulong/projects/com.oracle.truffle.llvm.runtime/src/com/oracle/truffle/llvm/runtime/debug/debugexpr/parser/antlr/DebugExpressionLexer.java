/*
 * Copyright (c) 2016, 2023, Oracle and/or its affiliates.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
// Checkstyle: stop
//@formatter:off
package com.oracle.truffle.llvm.runtime.debug.debugexpr.parser.antlr;

// DO NOT MODIFY - generated from DebugExpression.g4 using "mx create-parsers"

import org.graalvm.shadowed.org.antlr.v4.runtime.Lexer;
import org.graalvm.shadowed.org.antlr.v4.runtime.CharStream;
import org.graalvm.shadowed.org.antlr.v4.runtime.Token;
import org.graalvm.shadowed.org.antlr.v4.runtime.TokenStream;
import org.graalvm.shadowed.org.antlr.v4.runtime.*;
import org.graalvm.shadowed.org.antlr.v4.runtime.atn.*;
import org.graalvm.shadowed.org.antlr.v4.runtime.dfa.DFA;
import org.graalvm.shadowed.org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "this-escape"})
public class DebugExpressionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, LAPR=9, 
		RAPR=10, ASTERISC=11, PLUS=12, MINUS=13, DIVIDE=14, LOGICOR=15, LOGICAND=16, 
		DOT=17, POINTER=18, EXCLAM=19, TILDA=20, MODULAR=21, SHIFTR=22, SHIFTL=23, 
		GT=24, LT=25, GTE=26, LTE=27, EQ=28, NE=29, AND=30, OR=31, XOR=32, SIGNED=33, 
		UNSIGNED=34, INT=35, LONG=36, SHORT=37, FLOAT=38, DOUBLE=39, CHAR=40, 
		TYPEOF=41, IDENT=42, NUMBER=43, FLOATNUMBER=44, CHARCONST=45, WS=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "LETTER", 
			"NONDIGIT", "DIGIT", "CR", "LF", "SINGLECOMMA", "QUOTE", "CCHAR", "SIMPLE_ESCAPE_SEQUENCE", 
			"LAPR", "RAPR", "ASTERISC", "PLUS", "MINUS", "DIVIDE", "LOGICOR", "LOGICAND", 
			"DOT", "POINTER", "EXCLAM", "TILDA", "MODULAR", "SHIFTR", "SHIFTL", "GT", 
			"LT", "GTE", "LTE", "EQ", "NE", "AND", "OR", "XOR", "SIGNED", "UNSIGNED", 
			"INT", "LONG", "SHORT", "FLOAT", "DOUBLE", "CHAR", "TYPEOF", "IDENT", 
			"NUMBER", "FLOATNUMBER", "CHARCONST", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "','", "'sizeof'", "'?'", "':'", "'void'", "'long'", 
			"'('", "')'", "'*'", "'+'", "'-'", "'/'", "'||'", "'&&'", "'.'", "'->'", 
			"'!'", "'~'", "'%'", "'>>'", "'<<'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'&'", "'|'", "'^'", "'signed'", "'unsigned'", "'int'", "'LONG'", 
			"'short'", "'float'", "'double'", "'char'", "'typeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "LAPR", "RAPR", 
			"ASTERISC", "PLUS", "MINUS", "DIVIDE", "LOGICOR", "LOGICAND", "DOT", 
			"POINTER", "EXCLAM", "TILDA", "MODULAR", "SHIFTR", "SHIFTL", "GT", "LT", 
			"GTE", "LTE", "EQ", "NE", "AND", "OR", "XOR", "SIGNED", "UNSIGNED", "INT", 
			"LONG", "SHORT", "FLOAT", "DOUBLE", "CHAR", "TYPEOF", "IDENT", "NUMBER", 
			"FLOATNUMBER", "CHARCONST", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DebugExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DebugExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000.\u014d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u009b\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00012\u00012\u00012\u00052\u0114\b2\n2"+
		"\f2\u0117\t2\u00013\u00043\u011a\b3\u000b3\f3\u011b\u00014\u00044\u011f"+
		"\b4\u000b4\f4\u0120\u00014\u00014\u00044\u0125\b4\u000b4\f4\u0126\u0001"+
		"4\u00014\u00014\u00044\u012c\b4\u000b4\f4\u012d\u00034\u0130\b4\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00035\u0145"+
		"\b5\u00016\u00046\u0148\b6\u000b6\f6\u0149\u00016\u00016\u0000\u00007"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000"+
		"\u001b\u0000\u001d\u0000\u001f\u0000!\u0000#\t%\n\'\u000b)\f+\r-\u000e"+
		"/\u000f1\u00103\u00115\u00127\u00139\u0014;\u0015=\u0016?\u0017A\u0018"+
		"C\u0019E\u001aG\u001bI\u001cK\u001dM\u001eO\u001fQ S!U\"W#Y$[%]&_\'a("+
		"c)e*g+i,k-m.\u0001\u0000\b\u0002\u0000AZaz\u0003\u0000AZ__az\u0001\u0000"+
		"09\u0004\u0000\n\n\r\r\'\'\\\\\n\u0000\"\"\'\'??\\\\abffnnrrttvv\u0002"+
		"\u0000EEee\u0002\u0000++--\u0003\u0000\t\n\r\r  \u014f\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000"+
		"E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001"+
		"\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000"+
		"\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000"+
		"S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001"+
		"\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000"+
		"\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000"+
		"a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001"+
		"\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000"+
		"\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0001"+
		"o\u0001\u0000\u0000\u0000\u0003q\u0001\u0000\u0000\u0000\u0005s\u0001"+
		"\u0000\u0000\u0000\u0007u\u0001\u0000\u0000\u0000\t|\u0001\u0000\u0000"+
		"\u0000\u000b~\u0001\u0000\u0000\u0000\r\u0080\u0001\u0000\u0000\u0000"+
		"\u000f\u0085\u0001\u0000\u0000\u0000\u0011\u008a\u0001\u0000\u0000\u0000"+
		"\u0013\u008c\u0001\u0000\u0000\u0000\u0015\u008e\u0001\u0000\u0000\u0000"+
		"\u0017\u0090\u0001\u0000\u0000\u0000\u0019\u0092\u0001\u0000\u0000\u0000"+
		"\u001b\u0094\u0001\u0000\u0000\u0000\u001d\u0096\u0001\u0000\u0000\u0000"+
		"\u001f\u009a\u0001\u0000\u0000\u0000!\u009c\u0001\u0000\u0000\u0000#\u009f"+
		"\u0001\u0000\u0000\u0000%\u00a1\u0001\u0000\u0000\u0000\'\u00a3\u0001"+
		"\u0000\u0000\u0000)\u00a5\u0001\u0000\u0000\u0000+\u00a7\u0001\u0000\u0000"+
		"\u0000-\u00a9\u0001\u0000\u0000\u0000/\u00ab\u0001\u0000\u0000\u00001"+
		"\u00ae\u0001\u0000\u0000\u00003\u00b1\u0001\u0000\u0000\u00005\u00b3\u0001"+
		"\u0000\u0000\u00007\u00b6\u0001\u0000\u0000\u00009\u00b8\u0001\u0000\u0000"+
		"\u0000;\u00ba\u0001\u0000\u0000\u0000=\u00bc\u0001\u0000\u0000\u0000?"+
		"\u00bf\u0001\u0000\u0000\u0000A\u00c2\u0001\u0000\u0000\u0000C\u00c4\u0001"+
		"\u0000\u0000\u0000E\u00c6\u0001\u0000\u0000\u0000G\u00c9\u0001\u0000\u0000"+
		"\u0000I\u00cc\u0001\u0000\u0000\u0000K\u00cf\u0001\u0000\u0000\u0000M"+
		"\u00d2\u0001\u0000\u0000\u0000O\u00d4\u0001\u0000\u0000\u0000Q\u00d6\u0001"+
		"\u0000\u0000\u0000S\u00d8\u0001\u0000\u0000\u0000U\u00df\u0001\u0000\u0000"+
		"\u0000W\u00e8\u0001\u0000\u0000\u0000Y\u00ec\u0001\u0000\u0000\u0000["+
		"\u00f1\u0001\u0000\u0000\u0000]\u00f7\u0001\u0000\u0000\u0000_\u00fd\u0001"+
		"\u0000\u0000\u0000a\u0104\u0001\u0000\u0000\u0000c\u0109\u0001\u0000\u0000"+
		"\u0000e\u0110\u0001\u0000\u0000\u0000g\u0119\u0001\u0000\u0000\u0000i"+
		"\u011e\u0001\u0000\u0000\u0000k\u0144\u0001\u0000\u0000\u0000m\u0147\u0001"+
		"\u0000\u0000\u0000op\u0005[\u0000\u0000p\u0002\u0001\u0000\u0000\u0000"+
		"qr\u0005]\u0000\u0000r\u0004\u0001\u0000\u0000\u0000st\u0005,\u0000\u0000"+
		"t\u0006\u0001\u0000\u0000\u0000uv\u0005s\u0000\u0000vw\u0005i\u0000\u0000"+
		"wx\u0005z\u0000\u0000xy\u0005e\u0000\u0000yz\u0005o\u0000\u0000z{\u0005"+
		"f\u0000\u0000{\b\u0001\u0000\u0000\u0000|}\u0005?\u0000\u0000}\n\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005:\u0000\u0000\u007f\f\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005v\u0000\u0000\u0081\u0082\u0005o\u0000\u0000\u0082"+
		"\u0083\u0005i\u0000\u0000\u0083\u0084\u0005d\u0000\u0000\u0084\u000e\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005l\u0000\u0000\u0086\u0087\u0005o\u0000"+
		"\u0000\u0087\u0088\u0005n\u0000\u0000\u0088\u0089\u0005g\u0000\u0000\u0089"+
		"\u0010\u0001\u0000\u0000\u0000\u008a\u008b\u0007\u0000\u0000\u0000\u008b"+
		"\u0012\u0001\u0000\u0000\u0000\u008c\u008d\u0007\u0001\u0000\u0000\u008d"+
		"\u0014\u0001\u0000\u0000\u0000\u008e\u008f\u0007\u0002\u0000\u0000\u008f"+
		"\u0016\u0001\u0000\u0000\u0000\u0090\u0091\u0005\r\u0000\u0000\u0091\u0018"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\n\u0000\u0000\u0093\u001a\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0005\'\u0000\u0000\u0095\u001c\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\"\u0000\u0000\u0097\u001e\u0001\u0000\u0000"+
		"\u0000\u0098\u009b\b\u0003\u0000\u0000\u0099\u009b\u0003!\u0010\u0000"+
		"\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000"+
		"\u009b \u0001\u0000\u0000\u0000\u009c\u009d\u0005\\\u0000\u0000\u009d"+
		"\u009e\u0007\u0004\u0000\u0000\u009e\"\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0005(\u0000\u0000\u00a0$\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005)"+
		"\u0000\u0000\u00a2&\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005*\u0000\u0000"+
		"\u00a4(\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005+\u0000\u0000\u00a6*"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005-\u0000\u0000\u00a8,\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0005/\u0000\u0000\u00aa.\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005|\u0000\u0000\u00ac\u00ad\u0005|\u0000\u0000\u00ad0"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0005&\u0000\u0000\u00af\u00b0\u0005"+
		"&\u0000\u0000\u00b02\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005.\u0000"+
		"\u0000\u00b24\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005-\u0000\u0000\u00b4"+
		"\u00b5\u0005>\u0000\u0000\u00b56\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"!\u0000\u0000\u00b78\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005~\u0000"+
		"\u0000\u00b9:\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005%\u0000\u0000\u00bb"+
		"<\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005>\u0000\u0000\u00bd\u00be\u0005"+
		">\u0000\u0000\u00be>\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005<\u0000"+
		"\u0000\u00c0\u00c1\u0005<\u0000\u0000\u00c1@\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0005>\u0000\u0000\u00c3B\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005"+
		"<\u0000\u0000\u00c5D\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005>\u0000"+
		"\u0000\u00c7\u00c8\u0005=\u0000\u0000\u00c8F\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005<\u0000\u0000\u00ca\u00cb\u0005=\u0000\u0000\u00cbH\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0005=\u0000\u0000\u00cd\u00ce\u0005=\u0000"+
		"\u0000\u00ceJ\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005!\u0000\u0000\u00d0"+
		"\u00d1\u0005=\u0000\u0000\u00d1L\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005"+
		"&\u0000\u0000\u00d3N\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005|\u0000"+
		"\u0000\u00d5P\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005^\u0000\u0000\u00d7"+
		"R\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005s\u0000\u0000\u00d9\u00da\u0005"+
		"i\u0000\u0000\u00da\u00db\u0005g\u0000\u0000\u00db\u00dc\u0005n\u0000"+
		"\u0000\u00dc\u00dd\u0005e\u0000\u0000\u00dd\u00de\u0005d\u0000\u0000\u00de"+
		"T\u0001\u0000\u0000\u0000\u00df\u00e0\u0005u\u0000\u0000\u00e0\u00e1\u0005"+
		"n\u0000\u0000\u00e1\u00e2\u0005s\u0000\u0000\u00e2\u00e3\u0005i\u0000"+
		"\u0000\u00e3\u00e4\u0005g\u0000\u0000\u00e4\u00e5\u0005n\u0000\u0000\u00e5"+
		"\u00e6\u0005e\u0000\u0000\u00e6\u00e7\u0005d\u0000\u0000\u00e7V\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0005i\u0000\u0000\u00e9\u00ea\u0005n\u0000"+
		"\u0000\u00ea\u00eb\u0005t\u0000\u0000\u00ebX\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0005L\u0000\u0000\u00ed\u00ee\u0005O\u0000\u0000\u00ee\u00ef\u0005"+
		"N\u0000\u0000\u00ef\u00f0\u0005G\u0000\u0000\u00f0Z\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0005s\u0000\u0000\u00f2\u00f3\u0005h\u0000\u0000\u00f3"+
		"\u00f4\u0005o\u0000\u0000\u00f4\u00f5\u0005r\u0000\u0000\u00f5\u00f6\u0005"+
		"t\u0000\u0000\u00f6\\\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005f\u0000"+
		"\u0000\u00f8\u00f9\u0005l\u0000\u0000\u00f9\u00fa\u0005o\u0000\u0000\u00fa"+
		"\u00fb\u0005a\u0000\u0000\u00fb\u00fc\u0005t\u0000\u0000\u00fc^\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0005d\u0000\u0000\u00fe\u00ff\u0005o\u0000"+
		"\u0000\u00ff\u0100\u0005u\u0000\u0000\u0100\u0101\u0005b\u0000\u0000\u0101"+
		"\u0102\u0005l\u0000\u0000\u0102\u0103\u0005e\u0000\u0000\u0103`\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0005c\u0000\u0000\u0105\u0106\u0005h\u0000"+
		"\u0000\u0106\u0107\u0005a\u0000\u0000\u0107\u0108\u0005r\u0000\u0000\u0108"+
		"b\u0001\u0000\u0000\u0000\u0109\u010a\u0005t\u0000\u0000\u010a\u010b\u0005"+
		"y\u0000\u0000\u010b\u010c\u0005p\u0000\u0000\u010c\u010d\u0005e\u0000"+
		"\u0000\u010d\u010e\u0005o\u0000\u0000\u010e\u010f\u0005f\u0000\u0000\u010f"+
		"d\u0001\u0000\u0000\u0000\u0110\u0115\u0003\u0013\t\u0000\u0111\u0114"+
		"\u0003\u0013\t\u0000\u0112\u0114\u0003\u0015\n\u0000\u0113\u0111\u0001"+
		"\u0000\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117\u0001"+
		"\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001"+
		"\u0000\u0000\u0000\u0116f\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0118\u011a\u0003\u0015\n\u0000\u0119\u0118\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011ch\u0001\u0000\u0000\u0000"+
		"\u011d\u011f\u0003\u0015\n\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u0124\u0005.\u0000\u0000\u0123\u0125\u0003\u0015\n\u0000\u0124\u0123"+
		"\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0124"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u012f"+
		"\u0001\u0000\u0000\u0000\u0128\u0129\u0007\u0005\u0000\u0000\u0129\u012b"+
		"\u0007\u0006\u0000\u0000\u012a\u012c\u0003\u0015\n\u0000\u012b\u012a\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u0130\u0001"+
		"\u0000\u0000\u0000\u012f\u0128\u0001\u0000\u0000\u0000\u012f\u0130\u0001"+
		"\u0000\u0000\u0000\u0130j\u0001\u0000\u0000\u0000\u0131\u0132\u0003\u001b"+
		"\r\u0000\u0132\u0133\u0003\u001f\u000f\u0000\u0133\u0134\u0003\u001b\r"+
		"\u0000\u0134\u0145\u0001\u0000\u0000\u0000\u0135\u0136\u0005L\u0000\u0000"+
		"\u0136\u0137\u0003\u001b\r\u0000\u0137\u0138\u0003\u001f\u000f\u0000\u0138"+
		"\u0139\u0003\u001b\r\u0000\u0139\u0145\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0005u\u0000\u0000\u013b\u013c\u0003\u001b\r\u0000\u013c\u013d\u0003"+
		"\u001f\u000f\u0000\u013d\u013e\u0003\u001b\r\u0000\u013e\u0145\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u0005U\u0000\u0000\u0140\u0141\u0003\u001b\r"+
		"\u0000\u0141\u0142\u0003\u001f\u000f\u0000\u0142\u0143\u0003\u001b\r\u0000"+
		"\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0131\u0001\u0000\u0000\u0000"+
		"\u0144\u0135\u0001\u0000\u0000\u0000\u0144\u013a\u0001\u0000\u0000\u0000"+
		"\u0144\u013f\u0001\u0000\u0000\u0000\u0145l\u0001\u0000\u0000\u0000\u0146"+
		"\u0148\u0007\u0007\u0000\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0148"+
		"\u0149\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149"+
		"\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b"+
		"\u014c\u00066\u0000\u0000\u014cn\u0001\u0000\u0000\u0000\u000b\u0000\u009a"+
		"\u0113\u0115\u011b\u0120\u0126\u012d\u012f\u0144\u0149\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
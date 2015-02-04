package com.paracamplus.ilp9.interpreter.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp9.interfaces.IASTprogram;
import com.paracamplus.ilp9.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp9.interpreter.GlobalVariableStuff;
import com.paracamplus.ilp9.interpreter.IGlobalVariableEnvironment;
import com.paracamplus.ilp9.interpreter.ILexicalEnvironment;
import com.paracamplus.ilp9.interpreter.IOperatorEnvironment;
import com.paracamplus.ilp9.interpreter.Interpreter;
import com.paracamplus.ilp9.interpreter.LexicalEnvironment;
import com.paracamplus.ilp9.interpreter.OperatorEnvironment;
import com.paracamplus.ilp9.interpreter.OperatorStuff;
import com.paracamplus.ilp9.parser.IParser;
import com.paracamplus.ilp9.parser.IParserFactory;
import com.paracamplus.ilp9.tools.IProcess;
import com.paracamplus.ilp9.tools.Input;
import com.paracamplus.ilp9.tools.InputFromFile;

@RunWith(Parameterized.class)
public class ProcessTest {
    
    protected static String rngFileName = "grammar9.rng";
    protected static String samplesDirName = "Samples";
    protected static String pattern = "u[0-7]\\d*-[12345]";
    
    public ProcessTest(final File file) {
        this.file = file;
        this.process = new com.paracamplus.ilp9.interpreter.Process();
        IParserFactory factory = new com.paracamplus.ilp9.ast.ASTfactory();
        this.parser = new com.paracamplus.ilp9.ast.Parser(factory);
    }
    protected File file;
    
    public void setProcess (IProcess process) {
        this.process = process;
    }
    protected IProcess process;
    
    public void setParser (IParser parser) {
        this.parser = parser;
    }
    protected IParser parser;
    
    @Test
    public void processFile () throws Throwable {
        System.err.println("Testing " + file.getAbsolutePath() + " ...");
        assertTrue(file.exists());
        Input input = new InputFromFile(file);
        process.setInput(input);
        File rngFile = new File(rngFileName);
        process.setGrammar(rngFile);
        process.setParser(parser);
        IASTprogram program = process.getProgram();
        
        IGlobalVariableEnvironment gve = new GlobalVariableEnvironment();
        GlobalVariableStuff.fillGlobalVariables(gve);
        IOperatorEnvironment oe = new OperatorEnvironment();
        OperatorStuff.fillUnaryOperators(oe);
        OperatorStuff.fillBinaryOperators(oe);
        Interpreter interpreter = new Interpreter(gve, oe);
        ILexicalEnvironment lexenv = LexicalEnvironment.EMPTY;
        Object value = interpreter.visit(program, lexenv);
        System.err.println(value);
    }
    
    @Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
        //Path currentRelativePath = Paths.get("");
        //String s = currentRelativePath.toAbsolutePath().toString();
        //System.err.println("Current relative path is: " + s);
        
        final Pattern p = Pattern.compile("^" + pattern + ".xml$");
        final FilenameFilter ff = new FilenameFilter() {
            public boolean accept (File dir, String name) {
                final Matcher m = p.matcher(name);
                return m.matches();
            }
        };
        File samplesDir = new File(samplesDirName);
        final File[] testFiles = samplesDir.listFiles(ff);
        assertNotNull(testFiles);
        
        if ( testFiles.length == 0 ) {
            final String msg = "Cannot find a single test like " + pattern;
            throw new RuntimeException(msg);
        }

        // Old way before Java8:
//        java.util.Arrays.sort(testFiles,
//                new java.util.Comparator<java.io.File>() {
//            public int compare (java.io.File f1, java.io.File f2) {
//                return f1.getName().compareTo(f2.getName());
//            }
//        });
        java.util.Arrays.sort(testFiles,
                (f1, f2) -> f1.getName().compareTo(f2.getName()));

       Collection<File[]> result = new Vector<>();
        for ( final File f : testFiles ) {
            result.add(new File[]{ f });
        }
        return result;
    }
 

}

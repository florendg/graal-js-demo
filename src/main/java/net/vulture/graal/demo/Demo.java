package net.vulture.graal.demo;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;

import java.net.URL;

public class Demo {

    public static void main(String[] args) throws IOException {
        try(Context context = Context.create()) {
            URL url = Demo.class.getResource("demo.js");
            context.eval(Source.newBuilder("js", new File(url.getFile())).build());
            Value mainFunc = context.getBindings("js").getMember("mainFunc");
            mainFunc.execute();
        }
    }
}

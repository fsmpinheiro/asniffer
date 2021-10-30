package com.github.phillima.asniffer;


import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.phillima.asniffer.model.AMReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AM {

    private MetricsExecutor storage;
    private Stream<Stream<String>> partitions;

    public AM(MetricsExecutor storage, Stream<Stream<String>> partitions) {
        this.storage = storage;
        this.partitions = partitions;
    }

    public AMReport calculate() {
        partitions.forEach(stream ->
                storage.accept(stream
                        .map(File::new)
                        .filter(File::isFile)
                        .map(file -> parseFile(file))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
                )
        );
        return storage.getReport();
    }

    private CompilationUnit parseFile(File file) {
        try {
            return StaticJavaParser.parse(file);
          } catch (FileNotFoundException e) {
            return null;
        }
    }


}

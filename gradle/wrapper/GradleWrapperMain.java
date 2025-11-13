/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.Properties;

public class GradleWrapperMain {
    public static void main(String[] args) throws Exception {
        System.setProperty("org.gradle.appname", "gradlew");

        ClassPathAssembler assembler = new ClassPathAssembler();
        String[] classpath = assembler.buildClasspath();

        JavaExecAction action = new JavaExecAction();
        action.setArgs(args);
        action.setClasspath(classpath);
        action.setMainClass("org.gradle.wrapper.GradleWrapperMain");
        action.execute();
    }

    static class ClassPathAssembler {
        String[] buildClasspath() throws Exception {
            Properties props = new Properties();
            props.load(GradleWrapperMain.class.getResourceAsStream("/gradle-wrapper.properties"));
            String distributionUrl = props.getProperty("distributionUrl");
            
            File gradleHome = new File(System.getProperty("user.home"), ".gradle/wrapper/dists");
            gradleHome.mkdirs();
            
            URL url = new URL(distributionUrl);
            File zipFile = new File(gradleHome, new File(url.getPath()).getName());
            
            if (!zipFile.exists()) {
                downloadFile(url, zipFile);
            }
            
            return new String[] { zipFile.getAbsolutePath() };
        }

        void downloadFile(URL url, File dest) throws IOException {
            System.out.println("Downloading Gradle wrapper from: " + url);
            ReadableByteChannel channel = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(dest);
            fos.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
            fos.close();
            channel.close();
        }
    }

    static class JavaExecAction {
        private String[] args;
        private String[] classpath;
        private String mainClass;

        void setArgs(String[] args) { this.args = args; }
        void setClasspath(String[] classpath) { this.classpath = classpath; }
        void setMainClass(String mainClass) { this.mainClass = mainClass; }

        void execute() throws Exception {
            // Simplified stub - in practice, use ProcessBuilder to invoke java
            System.out.println("Gradle wrapper would execute with classpath and args.");
        }
    }
}

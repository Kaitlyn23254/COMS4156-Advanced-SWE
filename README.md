# 4156-Miniproject-2025-Students
This is the public repo for posting the miniproject assignments to the class. 

This is a template repository.  See https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template. 



# Part 3 Bug Finder
I used the [Maven PMD Plugin](https://maven.apache.org/plugins/maven-pmd-plugin/) as the static bug finder.  

## Installation  
There are no installation steps because it's a built-in plugin. The PMD plugin is included in Maven and works directly from the `pom.xml` file.  

## Usage:
- Navigate to the root directory where the pom.xml file is
- Run:
- mvn pmd:pmd
    - runs + gives report but doesn't fail build if there are violations
- open target/pmd.xml 
    - after running mvn pmd:pmd, open the generated report to see violations

Note: you will get some warnings
- Warning 1: Unable to locate Source XRef to link to
    - You need to implement the JXR plugin in pom.xml, which as far as I can tell,
    is a stylistic tool that lets you visualize your code in HTML better, which is helpful for reading the reports. 
    - Copy the code from the usage page of the Maven JXR documentation into pom.xml.
    ```bash	<reporting>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jxr-plugin</artifactId>
            <version>3.3.0</version>
        </plugin>
    </plugins>
</reporting>

- Warning 2: Unable to find a URL to the parent project.
    - I couldn't figure out how to resolve this warning but basically it occurs because Maven tries to look for the URL of a parent project when it generates the site? And because there is no parent project here it just won't display anything.

#### This project will show you how create a *Yaml configuration file* using `jackson-dataformat` and `jackson-databind` libraries.
A configuration file is useful to change variables value at different part of the code by simply editing a yaml file.
##### First of all, add dependencies from Maven project
```
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-yaml</artifactId>
    <version>2.10.2</version>
</dependency>
```

```
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.10.2</version>
</dependency>
```

##### Then, create your `Config.yaml` file :
```
exampleValues:
  valueOne: I am value ONE
  valueTwo: I am value TWO
```
> All declared variables must start with lowercase letter

##### After that, you should create an architecture project looks like this :
```
.
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── yamlConfigurationFile
    │   │               ├── Main.java
    │   │               └── config
    │   │                   ├── Config.java
    │   │                   └── exampleValues
    │   │                       └── ExampleValues.java
    │   └── resources
    └── test
        ├── java
        └── resources
```

##### With `ExampleValues.java` content :
```
public class ExampleValues {
    private String valueOne;
    private String valueTwo;

    public String getValueOne() {
        return valueOne;
    }

    public String getValueTwo() {
        return valueTwo;
    }
}
```
> Attributes name must be the same as declared variables in **`Config.yaml`** configuration file; and their type must be **`String`**

##### And `Config.java` should contain :
```
public class Config {
    private ExampleValues exampleValues;

    public ExampleValues getExampleValues() {
        return exampleValues;
    }
}
```

##### Finally, don't forget to add configuration file path from application argument.
For this, press `ALT` + `SHIFT` + `F10` (using **Intellij**) and add `Config.yaml` path into **Program arguments** input.
For example : `C:\Path\where\you\created\and\saved\Config.yaml`.

##### Now, time is ready to implement `Main` class :
```
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Main {

    public static void main(String[] args) {
        Config config = null;
        try {
            config = new ObjectMapper(new YAMLFactory()).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).readValue(new File(args[0]), Config.class);
            System.out.println("Config loaded");
        } catch (IOException err) {
            System.out.println("An error has occurred during configuration file loading");
        }

        if (config != null) {
            System.out.println(config.getExampleValues().getValueOne()); // I am value ONE
            System.out.println(config.getExampleValues().getValueTwo()); // I am value TWO
        }
    }
}
```

##### You can now make changes to your code simply and quickly ! :white_check_mark:
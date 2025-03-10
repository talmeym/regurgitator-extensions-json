# regurgitator-extensions-json

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](https://talmeym.github.io/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](https://talmeym.github.io/regurgitator-core-json#json-configuration-of-regurgitator)

## extension steps in json

### json-parameter

a json-parameter creates a parameter, extracting its value from within a json document, using json-path:

```json
{
    "kind": "json-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "json-path": "$.catalogue.book.name"
}
```

### xml-parameter

an xml-parameter creates a parameter, extracting its value from within an xml document, using xpath:

```json
{
    "kind": "xml-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "xpath": "/bk:catalogue/bk:book/bk:name",
    "namespaces": {
        "bk": "http://books.com"
    }
}
```

## extension constructs in json

### freemarker-builder 

a freemarker-builder aggregates parameter values together using a freemarker template.

```json
{
    "kind": "freemarker-builder",
    "source": "template-param"
}
```

```json
{
    "kind": "freemarker-builder",
    "file": "classpath:/template.ftl"
}
```

```json
{
    "kind": "freemarker-builder",
    "value": "This is a ${descriptive} day"
}
```

a freemarker-builder can use the same value source properties as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value.

a freemarker-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` property is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, e.g. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```json
{
    "kind": "freemarker-builder",
    "all-contexts": "true",
    "value": "{ \"payload\": \"${response_payload.text}\", \"status-code\": ${response_metadata.status_code}, \"content-type\": \"${response_metadata.content_type}\" }"
}
```

as well as defining a json template value as a string (shown above), they can also be defined as a json object, to be collapsed to a string upon loading.

```json
{
    "kind": "freemarker-builder",
    "all-contexts": "true",
    "value": { 
        "payload": "${response_payload.text}",
        "status-code": "${response_metadata.status_code}",
        "content-type": "${response_metadata.content_type}"
    }
}
```

### json-path-processor

a json-path-processor processes a parameter value, extracting a value from it using json path.

```json
{
    "kind": "create-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "processor": {
        "kind": "json-path-processor",
        "json-path": "$.catalogue.book.name"
    }
}
```

### xpath-processor

an xpath-processor processes a parameter value, extracting a value from it using xpath.

```json
{
    "kind": "create-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "processor": {
        "kind": "xpath-processor",
        "xpath": "/cat:catalogue/bk:book/@name",
        "namespaces": "cat=http://catalogues.com,bk=http://books.com"
    }
}
```

namespaces for an xpath-processor can also be declared as an object property of the processor:

```json
{
    "kind": "create-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "processor": {
        "kind": "xpath-processor",
        "xpath": "/cat:catalogue/bk:book/@name",
        "namespaces": {
            "cat": "http://catalogues.com",
            "bk": "http://books.com"
        }
    }
}
```

### freemarker-processor

a freemarker-processor processes a parameter value, formatting the value using a freemarker template.

```json
{
    "kind": "create-response",
    "source": "unformatted-response",
    "processor": {
        "kind": "freemarker-processor",
        "file": "classpath:/template.ftl"
    }
}
```

```json
{
    "kind": "create-response",
    "source": "unformatted-response",
    "processor": {
        "kind": "freemarker-processor",
        "value": "The response was: ${value}"
    }
}
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in a ``value`` property or drawn in from a file.

### json-schema-validator

a json-schema-validator is a ``value-processor`` that validates a parameter value against a json schema file.

```json
{
    "kind": "create-response",
    "source": "response",
    "processor": {
        "kind": "json-schema-validator",
        "file": "classpath:/response_schema.json"
    }
}
```

validating a parameter value can be useful in ensuring that your configured logic and processing always returns valid responses. if the value fails validation, an exception is thrown; if it passes, the value is passed through unchanged.

### xml-schema-validator

an xml-schema-validator is a ``value-processor`` that validates a parameter value against an xml schema file.

```json
{
    "kind": "create-response",
    "source": "response",
    "processor": {
        "kind": "xml-schema-validator",
        "file": "classpath:/response_schema.xsd"
    }
}
```

validating a parameter value can be useful in ensuring that your configured logic and processing always returns valid responses. if the value fails validation, an exception is thrown; if it passes, the value is passed through unchanged.

### contains-json-path

a contains-json-path is a ``condition-behaviour`` that checks whether a parameter's contents contains a sub-value that can be extracted using an json-path expression. if a sub-value can be extracted from the starting value using the json-path expression provided then the condition passes.

```json
...
    "conditions": [
        {
            "source": "parameters:json",
            "contains-json-path": "$.catalog.book.name"
        }
    ]
...
```

```json
...
    "conditions": [
        {
            "source": "parameters:json",
            "value" : "$.catalog.book.name"
            "behaviour": "contains-json-path"
        }
    ]
...
```

the examples above show both ways in which the contains-json-path ``condition-behaviour`` can be used, either in the short form of ``"behaviour-name" : "value"`` or with separate ``value`` and ``behaviour`` attributes.

### contains-xpath

a contains-xpath is a ``condition-behaviour`` that checks whether a parameter's contents contains a sub-value that can be extracted using an xpath expression. if a sub-value can be extracted from the starting value using the xpath expression provided then the condition passes.

```json
...
    "conditions": [
        {
            "source": "parameters:xml",
            "contains-xpath": "/catalogue/book/@name"
        }
    ]
...
```

```json
...
    "conditions": [
        {
            "source": "parameters:xml",
            "value" : "/catalog/book/@name"
            "behaviour": "contains-xpath"
        }
    ]
...
```

```json
...
    "conditions": [
        {
            "source": "parameters:xml",
            "value" : "/catalog/book/@name"
            "behaviour": {
                "kind": "contains-xpath"
                "namespaces": "cat=http://catalog.com,book=http://book.com"
            }
        }
    ]
...
```

```json
...
    "conditions": [
        {
            "source": "parameters:xml",
            "value" : "/catalog/book/@name"
            "behaviour": {
                "kind": "contains-xpath"
                "namespaces": {
                    "cat" : "http://catalog.com"
                    "book" : "http://book.com"
                }
            }
        }
    ]
...
```

the examples above shows 3 ways in which the contains-xpath ``condition-behaviour`` can be used: in the short form of ``"behaviour-name" : "value"``; with separate ``value`` and ``behaviour`` attributes; or with a child object. When using a child object, you can either specify namespaces for the xpath expression using a ``namespaces`` attribute, or a ``namespaces`` object.

### meets-json-schema

a meets-json-schema is a ``condition-behaviour`` that checks whether a parameters' content passes validation against a json schema.

```json
...
    "conditions": [
        {
            "source": "parameters:json",
            "meets-json-schema": "classpath:/schema.json"
        }
    ]
...
```

```json
...
    "conditions": [
        {
            "source": "parameters:json",
            "value" : "classpath:/schema.json"
            "behaviour": "meets-json-schema"
        }
    ]
...
```

the examples above show both ways in which the meets-json-schema ``condition-behaviour`` can be used, either in the short form of ``"behaviour-name" : "value"`` or with separate ``value`` and ``behaviour`` attributes.

### meets-xml-schema

a meets-xml-schema is a ``condition-behaviour`` that checks whether a parameters' content passes validation against an xml schema.

```json
...
    "conditions": [
        {
            "source": "parameters:xml",
            "meets-xml-schema": "classpath:/schema.xsd"
        }
    ]
...
```

```json
...
    "conditions": [
        {
            "source": "parameters:xml",
            "value" : "classpath:/schema.xsd"
            "behaviour": "meets-xml-schema"
        }
    ]
...
```

the examples above show both ways in which the meets-xml-schema ``condition-behaviour`` can be used, either in the short form of ``"behaviour-name" : "value"`` or with separate ``value`` and ``behaviour`` attributes.

---

api docs: [``0.1.4``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-json/0.1.4/){:target="_blank"} [``0.1.3``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-json/0.1.3/){:target="_blank"} [``0.1.2``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-json/0.1.2/){:target="_blank"}

# regurgitator-extensions-json

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](http://github.com/talmeym/regurgitator-core-json#json-configuration-of-regurgitator)

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

### velocity-builder

a freemarker-builder aggregates parameter values together using a freemarker template.

```json
{
    "kind": "velocity-builder",
    "source": "template-param"
}
```

```json
{
    "kind": "velocity-builder",
    "file": "classpath:/template.ftl"
}
```

```json
{
    "kind": "velocity-builder",
    "value": "This is a ${descriptive} day"
}
```

a velocity-builder can use the same value source properties as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value.

a velocity-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` property is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, e.g. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```json
{
    "kind": "velocity-builder",
    "all-contexts": "true",
    "value": "{ \"payload\": \"${response_payload.text}\", \"status-code\": ${response_metadata.status_code}, \"content-type\": \"${response_metadata.content_type}\" }"
}
```

as well as defining a json template value as a string (shown above), they can also be defined as a json object, to be collapsed to a string upon loading.

```json
{
    "kind": "velocity-builder",
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

### velocity-processor

a velocity-processor processes a parameter value, formatting the value using a velocity template.

```json
{
    "kind": "create-response",
    "source": "unformatted-response",
    "processor": {
        "kind": "velocity-processor",
        "file": "classpath:/template.ftl"
    }
}
```

```json
{
    "kind": "create-response",
    "source": "unformatted-response",
    "processor": {
        "kind": "velocity-processor",
        "value": "The response was: ${value}"
    }
}
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in a ``value`` property or drawn in from a file.

### xml-schema-validator

an xml-schema-validator is a ``value-processor`` that validates a parameter value against an xml-schema file.

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

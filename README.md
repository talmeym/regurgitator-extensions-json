# regurgitator-extensions-json

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](http://github.com/talmeym/regurgitator-core-json#json-configuration-of-regurgitator)

## extension steps in json

### json-parameter

a json-parameter creates a parameter, extracting it's value from within a json document, using json-path:

```json
{
    "kind": "json-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "json-path": "$.catalogue.book.name"
}
```

### xml-parameter

an xml-parameter creates a parameter, extracting it's value from within an xml document, using xpath:

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

## extension constructs in xml

### freemarker-builder 

### velocity-builder

### json-path-processor

### xpath-processor

### freemarker-processor

### velocity-processor

### xml-schema-validator

package resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "server")
public class myResource {
    private String name;
    private String id;
    private String language;
    private String framework;

    public myResource() {

    }

    public myResource(String name, String id, String language, String framework) {
        this.id = id;
        this.language = language;
        this.framework = framework;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
}
package co.goho.qingxu.mybatistag.config.datasource;

public enum DataSourceNames {
    FIRSRT("test"), SECOND("test1");

    private DataSourceNames(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

module com.dragon.pretty {
    requires javafx.controls;
    requires javafx.fxml;
    requires elasticsearch.java;
    requires elasticsearch.rest.client;
    requires org.apache.httpcomponents.httpcore;
    requires lombok;
	requires com.fasterxml.jackson.core;

    opens com.dragon.pretty to javafx.fxml;
    opens com.dragon.pretty.elastisearch.controller to javafx.fxml;
    exports com.dragon.pretty;
    exports com.dragon.pretty.elastisearch;
    exports com.dragon.pretty.elastisearch.controller;
}
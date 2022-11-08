module presentation.appui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens presentation.appui to javafx.fxml;
    exports presentation.appui;
}
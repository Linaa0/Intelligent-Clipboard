package com.clipboard.manager.clipboard;

import com.clipboard.manager.manager.SnippetManager;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class ClipboardMonitor {

    private final Clipboard clipboard;
    private final SnippetManager snippetManager;

    private String lastContent = "";

    public ClipboardMonitor(SnippetManager snippetManager) {

        this.snippetManager = snippetManager;

        this.clipboard =
                Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void checkClipboard() {

        try {

            if (clipboard.isDataFlavorAvailable(
                    DataFlavor.stringFlavor)) {

                String content =
                        (String) clipboard.getData(
                                DataFlavor.stringFlavor
                        );

                if (content != null &&
                        !content.equals(lastContent)) {

                    lastContent = content;

                    String type = detectType(content);

                    snippetManager.addSnippet(
                            content,
                            type
                    );

                    snippetManager.printHistory();

                    System.out.println(
                            "New snippet detected: " + type
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Could not read clipboard: "
                            + e.getMessage()
            );
        }
    }

    private String detectType(String content) {

        if (content.startsWith("http://") ||
                content.startsWith("https://")) {

            return "URL";
        }

        if (content.contains("Exception") ||
                content.contains("Error") ||
                content.contains("at java.")) {

            return "ERROR";
        }

        if (content.contains("public class") ||
                content.contains("public static void main") ||
                content.contains("import java.") ||
                content.contains("System.out.")) {

            return "CODE";
        }

        return "TEXT";
    }
}
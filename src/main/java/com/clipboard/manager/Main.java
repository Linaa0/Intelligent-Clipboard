package com.clipboard.manager;

import com.clipboard.manager.clipboard.ClipboardMonitor;
import com.clipboard.manager.manager.SnippetManager;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "Intelligent Clipboard Manager started."
        );

        SnippetManager snippetManager =
                new SnippetManager();

        ClipboardMonitor clipboardMonitor =
                new ClipboardMonitor(snippetManager);

        while (true) {

            clipboardMonitor.checkClipboard();

            try {

                Thread.sleep(500);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                break;
            }
        }
    }
}
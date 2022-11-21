package com.hivestead.plugin;

import com.turn.ttorrent.client.CommunicationManager;
import com.turn.ttorrent.client.FileMetadataProvider;
import com.turn.ttorrent.common.TorrentMetadata;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;
import java.nio.file.Path;

public class DownloadTorrentTask extends DefaultTask {
    private Path torrentFile;

    @TaskAction
    public void download() throws Exception {
       var torrentMetadata = new FileMetadataProvider(torrentFile.toString()).getTorrentMetadata();
    }

    @InputFile
    public Path getTorrentFile() {
        return torrentFile;
    }

    public void setTorrentFile(Path torrentFile) {
        this.torrentFile = torrentFile;
    }

    @OutputFile
    public Path getDataFile() {
        throw new AssertionError("not implemented");
    }
}

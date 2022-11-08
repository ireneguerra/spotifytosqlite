package es.ulpgc.spotify.downloader;

import es.ulpgc.spotify.downloader.campos.Album;
import es.ulpgc.spotify.downloader.campos.Artist;
import es.ulpgc.spotify.downloader.campos.Track;
import es.ulpgc.spotify.downloader.database.DatabaseManager;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    List<Artist> artistsList = new ArrayList<>();
    List<Album> albumsList;
    List<Track> tracksList;
    private final DatabaseManager databaseManager;
    private final GetData getData;
    public Controller() {
        this.getData = new GetData();
        this.databaseManager = new DatabaseManager();
    }
    public void control(Map<String, String> artists) throws Exception {
        Statement statement = databaseManager.init();
        for (String artistId : artists.keySet()) {
            artistsList.add(getData.getArtists(artistId));
            albumsList = getData.getAlbums(artistId);
            databaseManager.insertAlbums(statement, albumsList);
            for (Album album : albumsList) {
                String albumId = album.getId();
                tracksList = getData.getTracks(albumId);
                databaseManager.insertTracks(statement, tracksList);
                }
            }
            databaseManager.insertArtists(statement, artistsList);
        }
    }

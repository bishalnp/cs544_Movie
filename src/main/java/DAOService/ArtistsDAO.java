package DAOService;

import java.util.List;

import controller.Artists;

public interface ArtistsDAO {
	public List<Artists> getAllArtist();
	public List<Artists> getArtistCharacter();
}

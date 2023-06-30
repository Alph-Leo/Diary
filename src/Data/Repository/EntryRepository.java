package Data.Repository;

import Data.Models.Entry;

import java.util.List;

public interface EntryRepository {

    dtos.response.DiaryResponse createEntry(Entry entry);

    Entry updateEntry(Entry entry);

    Entry findEntryById(int id);

    List<Entry> viewAllEntries();
    void deleteEntryById(int id);

    void deleteAllEntries();
}

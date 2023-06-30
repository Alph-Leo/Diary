package Data.Repository;

import Data.Models.Entry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    private final List<Entry> entries =  new ArrayList<>();
    private LocalDate date;
    private int count = 0;

    @Override
    public dtos.response.DiaryResponse createEntry(Entry entry) {
        int addId = generateId();
        entry.setId(addId);
        entries.add(entry);
        count++;
        return null;
    }

    @Override
    public Entry updateEntry(Entry updatedEntry) {
        for (int index = 0; index < entries.size() ; index++){
            Entry entry = entries.get(index);
            if (entry.getId() == updatedEntry.getId()){
                entries.set(index, updatedEntry);
                break;
            }
        }
        return updatedEntry;
    }

    @Override
    public Entry findEntryById(int id) {
        for (Entry entry : entries) {
            if (entry.getId()+1 == id ) {
                return entry;
            }
        }
            return null;
    }

    @Override
    public List<Entry> viewAllEntries() {
        for (Entry entry : entries){
            if (entry != null) {
                System.out.printf("%s%n%s%n ", entry, LocalDate.now());
            }else {
                System.out.println("No entries found");
            }
        }
        return new ArrayList<>(entries);
    }

    @Override
    public void deleteEntryById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() + 1 == id) {
                entries.remove(entry);
                break;
            }
        }
    }
    @Override
    public void deleteAllEntries() {
        entries.clear();
    }

    public  int generateId(){
       return count;
    }
}

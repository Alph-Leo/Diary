package Service;

import Data.Models.Entry;
import Data.Repository.EntryRepository;
import Data.Repository.EntryRepositoryImpl;
import dtos.request.DiaryRequest;
import dtos.response.DiaryResponse;

import java.time.LocalDate;
import java.util.List;

public class DiaryServiceImpl implements DiaryService {
    private final EntryRepository entryRepository = new EntryRepositoryImpl();

    @Override
    public DiaryResponse saveEntry(DiaryRequest request) {
        Entry savedEntry = new Entry(request.getTitle(), request.getContent(), request.getDate());

        return entryRepository.createEntry(savedEntry);

    }

    @Override
    public Entry updateEntry(DiaryRequest request) {
        Entry entryToUpdate = entryRepository.findEntryById(request.getId());
        if (entryToUpdate != null) {
            entryToUpdate.setTitle(request.getTitle());
            entryToUpdate.setContent(request.getContent());
            entryToUpdate.setDate(request.getDate());
            entryRepository.updateEntry(entryToUpdate);
        }
        return entryRepository.updateEntry(entryToUpdate);
    }

        @Override
        public void findEntryById ( int id){
            Entry entry = entryRepository.findEntryById(id);
            if (entry != null) {
                System.out.println(entry);
            } else {
                System.out.println("Entry not found.");
            }
            entryRepository.findEntryById(id);

        }

        @Override
        public void deleteById ( int id){
            entryRepository.deleteEntryById(id);

        }

        @Override
        public List<Entry> allEntries() {

            return entryRepository.viewAllEntries();
        }

        @Override
        public void deleteAll () {
            entryRepository.deleteAllEntries();
        }
    }


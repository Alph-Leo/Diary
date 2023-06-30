package Service;

import Data.Models.Entry;
import dtos.request.DiaryRequest;
import dtos.response.DiaryResponse;

import java.util.List;

public interface DiaryService {

     DiaryResponse saveEntry(DiaryRequest request);
     Entry updateEntry(DiaryRequest request);
     void findEntryById(int id);
     void deleteById(int id);
     List<Entry> allEntries();
     void deleteAll();



}

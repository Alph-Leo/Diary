package controller;

    import Data.Models.Entry;
    import Service.DiaryService;
    import Service.DiaryServiceImpl;
    import dtos.request.DiaryRequest;
    import dtos.response.DiaryResponse;

public class DiaryController {
        private  final DiaryService diaryService = new DiaryServiceImpl();

       public void saveEntry(DiaryRequest request){
            diaryService.saveEntry(request);
       }
       public void updateEntry(DiaryRequest request){
            diaryService.updateEntry(request);
       }


        public void viewDiaryEntry(int id) {
            diaryService.findEntryById(id);
        }
        public void deleteById(int id){
           diaryService.deleteById(id);
        }


        public void listDiaryEntries() {
            diaryService.allEntries();

        }
        public void deleteAllDiaryEntries(){
            diaryService.deleteAll();

        }


}
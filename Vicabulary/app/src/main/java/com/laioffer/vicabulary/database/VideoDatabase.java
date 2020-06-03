package com.laioffer.vicabulary.database;

public class VideoDatabase {
    public VideoDatabase() {

    }

    public static void CreateDatabase(DatabaseHelper dbHelper) {
        dbHelper.onUpgrade(dbHelper.getReadableDatabase(),1,1);
        dbHelper.saveRecord("Disneys Zootopia", "Walt Disney Animation Studios",
                "3:09",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/zootopia/Popsicle Clip - Disneys Zootopia.mp4",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/zootopia/Popsicle Clip - Disneys Zootopia.en.srt",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/zootopia/Popsicle+Clip+-+Disneys+Zootopia.jpg");
        dbHelper.saveRecord("Frozen 2 - Into the Unknown", "DisneyMusicVEVO",
                "3:29",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/frozen/Idina Menzel AURORA - Into the Unknown (From Frozen 2).mp4",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/frozen/Idina Menzel AURORA - Into the Unknown (From Frozen 2).en.srt",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/frozen/Idina+Menzel+AURORA+-+Into+the+Unknown+(From+Frozen+2).jpg");
        dbHelper.saveRecord("Lifting Thor's Hammer - Avengers Age of Ultron",
                "BestClips","4:11",
                "s3://vicabulary-video/Avengers/Lifting Thors Hammer - Avengers Age of Ultron (2015) Movie CLIP HD.mp4",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Avengers/Lifting Thors Hammer - Avengers Age of Ultron (2015) Movie CLIP HD.en.srt",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Avengers/Lifting Thors Hammer - Avengers Age of Ultron (2015) Movie CLIP HD.jpg");
        dbHelper.saveRecord("Life is a Box of Chocolates - Forrest Gump",
                "Movieclips", "2:21",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Forrest Gump/Life is a Box of Chocolates - Forrest Gump (79) Movie CLIP (1994) HD.mp4",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Forrest Gump/Life is a Box of Chocolates - Forrest Gump (79) Movie CLIP (1994) HD.en.srt",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Forrest Gump/Life is a Box of Chocolates - Forrest Gump (79) Movie CLIP (1994) HD.jpg");
        dbHelper.saveRecord("You hate her - Flipped", "Movieclips","1:31",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Flipped/Flipped 8 Movie CLIP - You Hate Her (2010) HD.mp4",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Flipped/Flipped 8 Movie CLIP - You Hate Her (2010) HD.en.srt",
                "https://vicabulary-video.s3.us-east-2.amazonaws.com/Flipped/Flipped 8 Movie CLIP - You Hate Her (2010) HD.jpg");
    }
}

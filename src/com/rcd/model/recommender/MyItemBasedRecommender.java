package com.rcd.model.recommender;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import com.rcd.conn.ConstantRec;
import com.rcd.javabean.MovieInfo;
import com.rcd.model.GetMovieInfo;
import com.rcd.model.MyDataModel;

/* ratings.dat
 * UserID::MovieID::Rating::Timestamp
 * users.dat
 * UserID::Gender::Age::Occupation::Zip-code
 * movie.dat
 * MovieID::Title::Genres
 * 
 */

public class MyItemBasedRecommender {
	
	public List<RecommendedItem> myItemBasedRecommender(long userID,int size){
		List<RecommendedItem> recommendations = null;
		try {
			//文件方式获取
			DataModel model = new FileDataModel(new File(ConstantRec.RATING_PATH),"::");//构造数据模型，File-based
			//DataModel model = MyDataModel.myDataModel();//构造数据模型
			ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//计算内容相似度
			Recommender recommender = new GenericItemBasedRecommender(model, similarity);//构造推荐引擎
			recommendations = recommender.recommend(userID, size);//得到推荐接过
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}
	
	public static void main(String[] args) {
		MyItemBasedRecommender mubr = new MyItemBasedRecommender();
		//拿到推荐的电影
		List<RecommendedItem> recommendation = mubr.myItemBasedRecommender(75,10);
		GetMovieInfo getMovieInfo = new GetMovieInfo();
		//拿到推荐的电影的详细信息
		ArrayList<MovieInfo> recommendMovieInfo = getMovieInfo.getMovieByMovieId(recommendation);
		
		for (MovieInfo movieInfo : recommendMovieInfo) {
			String temp = movieInfo.getName();
			System.out.println(temp);
		}
	}

}

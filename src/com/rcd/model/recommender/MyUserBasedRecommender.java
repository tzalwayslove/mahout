package com.rcd.model.recommender;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;

import com.rcd.conn.ConstantRec;
import com.rcd.javabean.MovieInfo;
import com.rcd.model.GetMovieInfo;
import com.rcd.model.MyDataModel;

import java.io.File;
import java.util.*;

public class MyUserBasedRecommender {
	public List<RecommendedItem> userBasedRecommender(long userID,int size) {
		// step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
		List<RecommendedItem> recommendations = null;
		try {
			//DataModel model = MyDataModel.myDataModel();//构造数据模型
			DataModel model = new FileDataModel(new File(ConstantRec.RATING_PATH),"::");//构造数据模型
			
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);//用PearsonCorrelation 算法计算用户相似度
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);//计算用户的“邻居”，这里将与该用户最近距离为 3 的用户设置为该用户的“邻居”。
			Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, similarity));//采用 CachingRecommender 为 RecommendationItem 进行缓存
			recommendations = recommender.recommend(userID, size);//得到推荐的结果，size是推荐接过的数目
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}

	public static void main(String args[]) throws Exception {
		MyUserBasedRecommender mubr = new MyUserBasedRecommender();
		//拿到推荐的电影
		List<RecommendedItem> recommendation = mubr.userBasedRecommender(75,10);
		GetMovieInfo getMovieInfo = new GetMovieInfo();
		//拿到推荐的电影的详细信息
		ArrayList<MovieInfo> recommendMovieInfo = getMovieInfo.getMovieByMovieId(recommendation);
		
		for (MovieInfo movieInfo : recommendMovieInfo) {
			String temp = movieInfo.getName();
			System.out.println(temp);
		}

	}
}
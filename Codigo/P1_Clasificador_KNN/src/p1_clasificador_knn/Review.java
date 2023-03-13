/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_clasificador_knn;

/**
 *
 * @author anton
 */
public class Review implements Comparable<Review>{

    private String reviewTitle, reviewText, titleSentiment, textSentiment, starRating;
    private float wordCount, sentimentValue;
    private double dist;

    public Review(){
        dist = 0;
    }//Constructor
    
    public void setReviewTitle( String reviewTitle ){
        this.reviewTitle = reviewTitle;
    }//setReviewTitle
    public String getReviewTitle(){
      return reviewTitle;
    }//getReviewTitle

    public void setReviewText( String reviewText ){
        this.reviewText = reviewText;
    }//setReviewText
    public String getReviewText(){
      return reviewText;
    }//getReviewText

    public void setTitleSentiment( String titleSentiment ){
        this.titleSentiment = titleSentiment;
    }//setTitleSentiment
    public String getTitleSentiment(){
      return titleSentiment;
    }//getTitleSentiment

    public void setTextSentiment( String textSentiment ){
        this.textSentiment = textSentiment;
    }//setTextSentiment
    public String getTextSentiment(){
      return textSentiment;
    }//getTextSentiment

     public void setStarRating( String starRating ){
        this.starRating = starRating;
    }//setStarRating
    public String getStarRating(){
      return starRating;
    }//getStarRating

    public void setWordCount( float wordCount ){
        this.wordCount = wordCount;
    }//setWordCount
    public float getWordCount(){
      return wordCount;
    }//getWordCount

    public void setSentimentValue( float sentimentValue ){
        this.sentimentValue = sentimentValue;
    }//setSentimentValue
    public float getSentimentValue(){
      return sentimentValue;
    }//getSentimentValue

    public void setDist( double dist ){
        this.dist = dist;
    }//setDist
    public double getDist(){
      return dist;
    }//getDist

    //Metodo sobreescritos de la interfaz
    @Override
    public int compareTo( Review obj ){

        if(this.getDist() < obj.getDist()){
            return -1;
        }
        else if(this.getDist() > obj.getDist()){
            return 1;
        }
        else{
            return 0;
        }
    }

}//Clase Review

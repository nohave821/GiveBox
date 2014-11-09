package storyBoard.bean;

import storyBoard.service.StoryBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoryBoardPaging {
	@Autowired
	private StoryBoardService StoryBoardService;
	int currentPage;//현재페이지
	int pageBlock;//[이전][1][2][3][이후]
	int pageSize;//1페이지당 5개씩 글 뿌리기
	StringBuffer pagingHTML;
	
	public StoryBoardPaging(){}
	
	public StoryBoardPaging(int currentPage, int pageBlock, int pageSize) {
		this.currentPage = currentPage;
		this.pageBlock = pageBlock;
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public void setPagingHTML(StringBuffer pagingHTML) {
		this.pagingHTML = pagingHTML;
	}



	public void makePagingHTML(){
		pagingHTML=new StringBuffer();
		
		int totalA=StoryBoardService.getStoryTotalArticle();//총글수	
		int totalP=(totalA+pageSize-1)/pageSize;//총페이지수
		
		int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		
		if(endPage>totalP){
			endPage=totalP;
		}
				
		//---------------------
		if(startPage>pageBlock){			
			pagingHTML.append("<li> <a " +
					"href='javascript:boardPaging("+(startPage-pageBlock)+")'>&lt&lt</a></li>");
		}	
		
		for(int i=startPage;i<=endPage;i++){
			if(currentPage==i){
				pagingHTML.append("<li> <a " +
						"href='javascript:boardPaging("+i+")'>"+i+"</a></li>");
			
			}else{
				pagingHTML.append("<li> <a " +
						"href='javascript:boardPaging("+i+")'>"+i+"</a></li>");
			}
		}
		
		if(endPage<totalP){
			pagingHTML.append("<li> <a " +
					"href='javascript:boardPaging("+(startPage+pageBlock)+")'>&gt&gt</a></li>");
		}
	}
	
	public String getPagingHTML() {
		return pagingHTML.toString();
	}	
}
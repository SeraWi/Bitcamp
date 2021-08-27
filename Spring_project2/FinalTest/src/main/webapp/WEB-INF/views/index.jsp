<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오를래-myFeed</title>

<%@ include file="/WEB-INF/views/frame/commons/metaheader.jsp" %>
<%@ include file="/WEB-INF/views/frame/feed/metaFeed.jsp" %>

</head>
<body>
	<%@ include file="/WEB-INF/views/frame/commons/header.jsp" %>

	    <div class="container1">

        <!-- 프로필 영역 -->
        <section class="bio">
            <!-- 사진 영역 -->
            <div class="profile-photo">
                <img src="<c:url value="/images/feeds/profile-photo.jpg"/>" alt="profile-photo">
            </div>

            <!-- 사용자 정보 영역: username, follow-infos, user-post,buttons -->
            <div class="profile-info">

                <!-- 사용자 id -->
                <div class="username">
                    <a href="#">Cool_123456789000000000</a>
                </div>


                <ul class="follow-infos">
                    <li>게시물 113</li>
                    <li><a href="#">팔로우 300</a></li>
                    <li><a href="#">팔로워 300</a></li>
                </ul>

                <!-- 게시글 -->
                <div class="user-post">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Temporibus ratione consequuntur et ex, reiciendis natus qui quo repellendus ad fugit quis sunt dignissimos? A sequi odit velit voluptatibus commodi rerum?</p>
                </div>

                <!-- 버튼 -->
                <div class="buttons">
                    <input type="submit" value="내 정보 수정">
                    <input type="submit" value="사진업로드">
                </div>
            
            </div>


        </section>


        <!-- 내크루 가기 추가 ->Swiper사용 -->
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름크루크루크루크루크루</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크크크루루루!</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>

              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름10글자까지</div>
                </a>
              </div>
              
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>넘어가면잘린다..</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>clickclick</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>

              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>

              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>

              <div class="swiper-slide">
                <a href="#" class="crew">
                    <img src="<c:url value="/images/feeds/plus.png"/>" alt="">
                    <div>MORE</div>
                </a>
              </div>

            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
          </div>
      
          <!-- Swiper JS -->
          <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
      
          <!-- Initialize Swiper -->
          <script>
            var swiper = new Swiper(".mySwiper", {
              slidesPerView: 6,
              spaceBetween: -40,
              slidesPerGroup: 6,
              loop: true,
              loopFillGroupWithBlank: true,
              pagination: {
                el: ".swiper-pagination",
                clickable: true
              },
              navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev"
              }
            });
          </script>

        <!-- 갤러리 네비게이션 영역 : 피드보기랑 좋아요 보기 -->
        <div class="gallery-nav">
            <div class="feed-icon"><a href="#"><img  src="<c:url value="/images/feeds/feedicon.png"/>"></a></div>
            <div class="heart-icon"><a href="#"><img src="<c:url value="/images/feeds/redheart.png"/>"></a></div>
            
        </div>

        <!-- 사진 피드 영역  -->
        <section class="gallery">

            <a href="#" class="item">
              <img src="https://images.pexels.com/photos/2829336/pexels-photo-2829336.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>

            <a href="#" class="item">
              <img src="https://images.pexels.com/photos/3598706/pexels-photo-3598706.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/3598706/pexels-photo-3598706.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/2829336/pexels-photo-2829336.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/2739505/pexels-photo-2739505.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/6051221/pexels-photo-6051221.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/3598706/pexels-photo-3598706.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
        </section>


        <nav aria-label="Page navigation example ">
            <ul class="pagination">
              <li class="page-item"><a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <!-- <span class="sr-only">Previous</span> -->
                  </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">4</a></li>
              <li class="page-item"><a class="page-link" href="#">5</a></li>
              <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <!-- <span class="sr-only">Next</span> -->
                    </a>
                </li>
            </ul>
    </nav>
       

    </div>
	
	
	
	<%@ include file="/WEB-INF/views/frame/commons/footer.jsp" %>
	
	
</body>
</html>
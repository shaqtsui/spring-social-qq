##Config:

The config can be done by spring boot autoconfig.

U only need to impl & register SignInAdapter to context to perform signin after oauth check

 
##Usage:
 
1. Add maven depency into your project

		<dependency>
			<groupId>net.gplatform</groupId>
			<artifactId>spring-social-qq</artifactId>
			<version>1.0.2</version>
		</dependency>
	
	
2. Config appId & appSecret
	* Copy [qqconnectconfig.properties](src/main/resources/qqconnectconfig.properties) to your project classpath & change app_ID & app_KEY to the value you retrieved from Tencent
	*Note:* This is used by QQ SDK.
	
	* Also add above value under key `spring.social.qq.appId` & `spring.social.qq.appSecret` in application.properties
	*Note:* This is used by spring boot


3. Implement SignInAdapter
	Code Example:
		
		@Component
		public class MySignInAdapter implements SignInAdapter {
			@Override
			public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
				LoginUtil.signin(localUserId, null);
				
				String goToURL = "/home"
				return goToURL;
			}
		}

 	
 	
4. Add QQ login button in your page

	Code Example:
	
		<form method="POST" action="/yourAppName/signin/qq">
			<input type="hidden" name="scope" value="get_user_info,add_topic,add_one_blog,add_album,upload_pic,list_album,add_share,check_page_fans,add_t,add_pic_t,del_t,get_repost_list,get_info,get_other_info,get_fanslist,get_idollist,add_idol,del_ido,get_tenpay_addr">
			<div class="row" style="margin-left: 10px;">
				<button type="submit">
					Login With QQ
				</button>
			</div>
		</form>
		
	*Note*: You need to replace `yourAppName` with correct value. For supported scope value, please refer to Open QQ specification in [http://open.qq.com/](http://open.qq.com/)
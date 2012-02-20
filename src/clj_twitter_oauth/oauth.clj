(ns clj-twitter-oauth.oauth
  (require [oauth.client :as oauth]
           [com.twinql.clojure.http :as http]))

(def consumer (oauth/make-consumer <This app's consumer token>
                                   <This app's consumer token secret>
                                   "http://twitter.com/oauth/request_token"
                                   "http://twitter.com/oauth/access_token"
                                   "http://twitter.com/oauth/authorize"
                                   :hmac-sha1))

(def credentials (oauth/credentials consumer
                                    <user's oauth token> 
                                    <user's oauth token secret>
                                    :POST
                                    "http://twitter.com/statuses/update.json"
                                    {:status "TEST: last one. I swear"}))

(http/post "http://twitter.com/statuses/update.json" 
           :query (merge credentials 
                         {:status "TEST: last one. I swear"}))
           ;:parameters (http/map->params {:use-expect-continue false}))


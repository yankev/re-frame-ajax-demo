(ns rf-api.events
    (:require [re-frame.core :as re-frame]
              [rf-api.db :as db]
              [ajax.core :refer [GET POST]]))
(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :user-input-change
  (fn [db [action text]]
    (assoc db :user-name-input text)))

(re-frame/reg-event-db
  :search
  (fn [db [action text]]
    (ajax.core/GET
      (str "https://api.github.com/users/" text)
      {:handler       #(re-frame/dispatch [:process-user-response %1])
       :error-handler #(re-frame/dispatch [:bad-response %1])})
    db))


(re-frame/reg-event-db
 :process-user-response
 (fn [db [_ response]]
  ;  (-> db
  ;    (assoc :profile (js->clj response)))))
    (let [js-resp (js->clj response)
          avatar-url (get js-resp "avatar_url")]
      (js/alert avatar-url)
      (-> db
        (assoc :status "success")
        (assoc :avatar-url avatar-url)))))
(re-frame/reg-event-db
 :bad-response
 (fn [db [_ response]]
  ;  (-> db
  ;    (assoc :name (js->clj response)))))
    (js/alert "Got nothing for this user")
    (-> db
      (assoc :status "error!")
      (assoc :avatar-url ""))))

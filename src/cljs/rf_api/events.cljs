(ns rf-api.events
    (:require [re-frame.core :as re-frame]
              [rf-api.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :artist-input-change
  (fn [db [action text]]
    (assoc db :artist-name-input text)))

(re-frame/reg-event-db
  :search
  (fn [db [action text]]
    (assoc db :artist-name-input text)))

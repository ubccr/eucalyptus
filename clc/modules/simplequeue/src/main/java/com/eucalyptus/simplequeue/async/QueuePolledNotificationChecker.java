/*************************************************************************
 * Copyright 2009-2014 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.simplequeue.async;

import com.eucalyptus.auth.policy.ern.Ern;
import com.eucalyptus.simplequeue.Constants;
import com.eucalyptus.simplequeue.common.policy.SimpleQueueResourceName;
import com.eucalyptus.simplequeue.persistence.PersistenceFactory;
import com.eucalyptus.simplequeue.persistence.Queue;
import com.eucalyptus.simpleworkflow.common.stateful.PolledNotificationChecker;

import javax.annotation.Nullable;

/**
 * Created by ethomas on 12/14/16.
 */
public class QueuePolledNotificationChecker implements PolledNotificationChecker {
  @Override
  public boolean apply(@Nullable String channel) {
    try {
      Ern ern = Ern.parse(channel);
      // may be applicable only if channel is a queue arn
      if (!(ern instanceof SimpleQueueResourceName)) {
        return false;
      }
      Queue queue = PersistenceFactory.getQueuePersistence().lookupQueue(ern.getAccount(), ern.getResourceName());
      if (queue == null) {
        return false;
      }
      return Long.parseLong(PersistenceFactory.getMessagePersistence().getApproximateMessageCounts(queue.getKey()).get(Constants.APPROXIMATE_NUMBER_OF_MESSAGES)) > 0;
    } catch (Exception ignore) {
    }
    return false;
  }
}

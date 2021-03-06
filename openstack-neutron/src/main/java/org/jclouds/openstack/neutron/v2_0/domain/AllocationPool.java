/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.openstack.neutron.v2_0.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;

import java.beans.ConstructorProperties;

/**
 * A Neutron Subnet Allocation Pool
 *
 * @see <a href="http://docs.openstack.org/api/openstack-network/2.0/content/Subnets.html">api doc</a>
 */
public class AllocationPool {

   private final String start;
   private final String end;

   @ConstructorProperties({
      "start", "end"
   })
   protected AllocationPool(String start, String end) {
      this.start = start;
      this.end = end;
   }

   /**
    * @return the start ip
    */
   public String getStart() {
      return start;
   }

   /**
    * @return the end ip
    */
   public String getEnd() {
      return end;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(start, end);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      AllocationPool that = AllocationPool.class.cast(obj);
      return Objects.equal(this.start, that.start) && Objects.equal(this.end, that.end);
   }

   protected ToStringHelper string() {
      return MoreObjects.toStringHelper(this).add("start", start).add("end", end);
   }

   @Override
   public String toString() {
      return string().toString();
   }

   public static Builder builder() {
      return new ConcreteBuilder();
   }

   public Builder toBuilder() {
      return new ConcreteBuilder().fromAllocationPool(this);
   }

   public abstract static class Builder {
      protected abstract Builder self();

      protected String start;
      protected String end;

      /**
       * @see org.jclouds.openstack.neutron.v2_0.domain.AllocationPool#getStart()
       */
      public Builder start(String start) {
         this.start = start;
         return self();
      }

      /**
       * @see org.jclouds.openstack.neutron.v2_0.domain.AllocationPool#getEnd()
       */
      public Builder end(String end) {
         this.end = end;
         return self();
      }

      public AllocationPool build() {
         return new AllocationPool(start, end);
      }

      public Builder fromAllocationPool(AllocationPool in) {
         return this.start(in.getStart()).end(in.getEnd());
      }
   }

   private static class ConcreteBuilder extends Builder {
      @Override
      protected ConcreteBuilder self() {
         return this;
      }
   }

}
